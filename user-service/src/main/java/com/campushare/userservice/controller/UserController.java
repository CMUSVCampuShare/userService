
package com.campushare.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campushare.userservice.model.User;
import com.campushare.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return service.addUser(user);
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
