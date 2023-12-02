package com.campushare.userservice.builder;

import java.util.Date;

import com.campushare.userservice.model.User;
//import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Role;

public interface UserBuilder {
    User build();

    UserBuilder reset();

    UserBuilder setUsername(String username);

    UserBuilder setPassword(String password);

    UserBuilder setEmail(String email);

    UserBuilder setEntryTime(String entryTime);

    UserBuilder setExitTime(String exitTime);

    UserBuilder setAddress(String address);

    UserBuilder setRole(Role role);

    UserBuilder setPayPalAccount(String account);
    
}
