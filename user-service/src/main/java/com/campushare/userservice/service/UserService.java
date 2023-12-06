
package com.campushare.userservice.service;

import java.util.List;
import java.util.UUID;
import org.mindrot.jbcrypt.BCrypt;
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

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserByUserId(String userId) {
        return repository.findById(userId).get();
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }


    public User updateUser(String userId, User userRequest) {
        User existingUser = repository.findById(userId).get();
        if (userRequest.getAddress() != null) {
            existingUser.setAddress(userRequest.getAddress());
        }
        if (userRequest.getPassword() != null) {
            //String salt = "$2a$10$abcdefghijklmnopqrstuu";
            //String hashedPassword = BCrypt.hashpw(userRequest.getPassword(), salt);
            existingUser.setPassword(userRequest.getPassword());
        }
        if (userRequest.getEntryTime() != null) {
            existingUser.setEntryTime(userRequest.getEntryTime());
        }
        if (userRequest.getExitTime() != null) {
            existingUser.setExitTime(userRequest.getExitTime());
        }
        if (userRequest.getNoOfSeats() != null) {
            existingUser.setNoOfSeats(userRequest.getNoOfSeats());
        }
        if (userRequest.getLicenseNo() != null) {
            existingUser.setLicenseNo(userRequest.getLicenseNo());
        }
        
        return repository.save(existingUser);
    }

    public String deleteUser(String userId) {
        repository.deleteById(userId);
        return userId + " user deleted";
    }

}
