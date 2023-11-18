
package com.campushare.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campushare.userservice.builder.DriverUserBuilder;
import com.campushare.userservice.builder.RiderUserBuilder;
import com.campushare.userservice.builder.UserBuilder;
import com.campushare.userservice.model.User;
import com.campushare.userservice.service.UserService;
//import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Role;
//import com.campushare.userservice.utils.Schedule;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

  @PostMapping("/users")
public User createUser(@RequestBody User userCreationRequest) {
    UserBuilder userBuilder;
    if (userCreationRequest.getRole() == Role.RIDER) {
        userBuilder = new RiderUserBuilder();
    } else if (userCreationRequest.getRole() == Role.DRIVER) {
        userBuilder = new DriverUserBuilder();
    } else {
        // Handle other roles or throw an exception
        throw new IllegalArgumentException("Invalid role");
    }

    return userBuilder
            .setUsername(userCreationRequest.getUsername())
            .setPassword(userCreationRequest.getPassword())
            .setEmail(userCreationRequest.getEmail())
            .setSchedule(userCreationRequest.getSchedule())
            .setAddress(userCreationRequest.getAddress())
            .setRole(userCreationRequest.getRole())
            .setPayPalAccount(userCreationRequest.getAccount())
            .build();
} 

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserByUserId(@PathVariable String userId) {
        return service.getUserByUserId(userId);
    }

    @GetMapping("/users/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    /*
     * @GetMapping("/{username}")
     * public List<User> getAddress(@PathVariable String username) {
     * return service.getAddressByUsername(username);
     * }
     */

    @PutMapping("/users/{userId}")
    public User modifyUser(@PathVariable String userId, @RequestBody User user) {
        return service.updateUser(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserByUserId(@PathVariable String userId) {
        return service.deleteUser(userId);
    }

}
