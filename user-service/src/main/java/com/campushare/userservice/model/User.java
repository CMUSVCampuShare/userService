package main.java.com.campushare.userservice.model;

import com.campushare.userservice.utils.Role;
import com.campushare.userservice.utils.Address;
import com.campushare.userservice.utils.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
   @Id
    private String username;
    private String password;
    private String email;
    private Integer rewardpts;
    private Role role;
    private Schedule schedule;
    private Address address;

}