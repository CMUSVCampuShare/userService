package com.campushare.userservice.builder;


import com.campushare.userservice.model.User;
import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Role;
import com.campushare.userservice.utils.Schedule;

public class RiderUserBuilder implements UserBuilder {

    private User user = new User();

    public RiderUserBuilder() {
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
        this.user.setPassword(password);
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.user.setEmail(email);
        return this;
    }

    @Override
    public UserBuilder setSchedule(Schedule schedule) {
        this.user.setSchedule(schedule);
        return this;
    }

    @Override
    public UserBuilder setAddress(Address address) {
        this.user.setAddress(address);
        return this;
    }

    @Override
    public UserBuilder setRole(Role role) {
        this.user.setRole(role);
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
