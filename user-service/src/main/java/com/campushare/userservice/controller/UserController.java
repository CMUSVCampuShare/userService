
package main.java.com.campushare.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.campushare.post.model.User;
import com.campushare.post.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

   /*  @GetMapping("/{username}")
   public List<User> getAddress(@PathVariable String username) {
      return service.getAddressByUsername(username);
   }
   */

   @PutMapping
   public User modifyUser(@RequestBody User user) {
       return service.updateUser(user);
   }


   @DeleteMapping("/{username}")
   public String deleteUser(@PathVariable String username) {
       return service.deleteUser(username);
   }

 

}
