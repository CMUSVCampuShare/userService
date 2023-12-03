package com.campushare.userservice.builder;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.campushare.userservice.model.User;
//import com.campushare.userservice.model.Address;
//import com.campushare.userservice.model.Schedule;
import com.campushare.userservice.utils.Role;

public class DriverUserBuilder implements UserBuilder {
    private User user = new User();

    public DriverUserBuilder() {
        this.reset();
    }

    @Override
    public UserBuilder reset() {
        this.user = new User();
        return this;
    }

    @Override
    public UserBuilder setUsername(String username) {
        this.user.setUsername(username);
        return this;
    }
    
    @Override
    public UserBuilder setPassword(String password) {
        // Hash the password before storing it
        String salt = "$2a$10$abcdefghijklmnopqrstuu";
        String hashedPassword = BCrypt.hashpw(password, salt);
        this.user.setPassword(hashedPassword);
        return this;
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        // Check if the plain password matches the hashed password
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.user.setEmail(email);
        return this;
    }
    
    @Override
    public UserBuilder setEntryTime(String entryTime) {
        this.user.setEntryTime(entryTime);
        return this;
    }

    @Override
    public UserBuilder setExitTime(String exitTime) {
        this.user.setExitTime(exitTime);
        return this;
    }

    

    @Override
    public UserBuilder setAddress(String address) {
        this.user.setAddress(address);
        return this;
    }

    @Override
    public UserBuilder setRole(Role role) {
        this.user.setRole(role);
        return this;
    }

    public DriverUserBuilder setNoOfSeats(Integer noOfSeats) {
        this.user.setNoOfSeats(noOfSeats);
        return this;
    }

    public DriverUserBuilder setLicenseNo(String licenseNo) {
        this.user.setLicenseNo(licenseNo);
        return this;
    }

    public UserBuilder setPayPalAccount(String account) {
        this.user.setAccount(account);
        return this;
    }

    public User build() {
        return this.user;
    }


}
