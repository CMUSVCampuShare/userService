
package com.campushare.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.campushare.userservice.utils.Topic;
import com.campushare.userservice.builder.DriverUserBuilder;
import com.campushare.userservice.builder.RiderUserBuilder;
import com.campushare.userservice.builder.UserBuilder;
import com.campushare.userservice.dto.UserDTO;
import com.campushare.userservice.kafka.UserProducer;
import com.campushare.userservice.model.User;
import com.campushare.userservice.service.UserService;
import com.campushare.userservice.utils.Role;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserProducer userProducer;

@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User userCreationRequest) {
    UserBuilder userBuilder;
    if (userCreationRequest.getRole() == Role.RIDER) {
        userBuilder = new RiderUserBuilder();
    } else if (userCreationRequest.getRole() == Role.DRIVER) {
        userBuilder = new DriverUserBuilder();
    } else {
        // Handle other roles or throw an exception
        throw new IllegalArgumentException("Invalid role");
    }

    User user = userBuilder
            .setUsername(userCreationRequest.getUsername())
            .setPassword(userCreationRequest.getPassword())
            .setEmail(userCreationRequest.getEmail())
            .setEntryTime(userCreationRequest.getEntryTime())
            .setExitTime(userCreationRequest.getExitTime())
            .setAddress(userCreationRequest.getAddress())
            .setRole(userCreationRequest.getRole())
            .setPayPalAccount(userCreationRequest.getAccount())
            .build();
    service.addUser(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
} 

   
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity<List<User>> responseEntity;
        try {
            List<User> users = service.getAllUsers();
            responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


     @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        ResponseEntity<User> responseEntity;
        try {
            User user = service.getUserByUserId(userId);
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception ex) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


   @GetMapping("/users/findBy/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        ResponseEntity<User> responseEntity;
        try {
            User user = service.getUserByUsername(username);
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception ex) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    } 

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> editUser(@PathVariable String userId, @RequestBody User user) {
        ResponseEntity<User> responseEntity;
        try {
            User editedUser = service.updateUser(userId, user);

            UserDTO userDTO = new UserDTO();
            userDTO.setUser(editedUser);
            userProducer.sendMessage(Topic.EDIT, userDTO);

            responseEntity = new ResponseEntity<>(editedUser, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    } 


    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        ResponseEntity<Void> responseEntity = null;
        try {
            service.deleteUser(userId);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
