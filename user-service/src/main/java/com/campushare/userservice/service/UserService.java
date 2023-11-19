
package com.campushare.userservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campushare.userservice.model.User;
import com.campushare.userservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // CRUD

    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return repository.save(user);

    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserByUserId(String userId) {
        return repository.findById(userId).get();
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    /*
     * public List<User> getAddressByUsername(String username) {
     * return repository.getAddressesByUsername(username);
     * }
     */

    public User updateUser(String userId, User userRequest) {
        User existingUser = repository.findById(userId).get();
        existingUser.setAddress(userRequest.getAddress());
        return repository.save(existingUser);
    }

    public String deleteUser(String userId) {
        repository.deleteById(userId);
        return userId + " user deleted";
    }

}
