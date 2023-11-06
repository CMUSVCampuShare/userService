package com.campushare.userservice.model;

import com.campushare.userservice.utils.Role;
import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String username;
    private String password;
    private String email;
    private Integer rewardpts;
    private Role role;
    private Schedule schedule;
    private Address address;

}
