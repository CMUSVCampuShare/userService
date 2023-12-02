package com.campushare.userservice.model;

import com.campushare.userservice.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
    private Role role;
    private String entryTime;
    private String exitTime;
    private String address;
    private String account;
    private Integer noOfSeats;
    private String licenseNo;
  
}
