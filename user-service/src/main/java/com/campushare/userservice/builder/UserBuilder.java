package com.campushare.userservice.builder;

import com.campushare.userservice.model.User;
//import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Role;
import com.campushare.userservice.utils.Schedule;

public interface UserBuilder {
    User build();

    UserBuilder reset();

    UserBuilder setUsername(String username);

    UserBuilder setPassword(String password);

    UserBuilder setEmail(String email);

    UserBuilder setSchedule(Schedule schedule);

    UserBuilder setAddress(String address);

    UserBuilder setRole(Role role);

    UserBuilder setPayPalAccount(String account);
    
}
