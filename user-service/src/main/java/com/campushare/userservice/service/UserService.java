
package main.java.com.campushare.userservice.service;

import java.util.List;

import main.java.com.campushare.userservice.model.User;
import main.java.com.campushare.userservice.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    //CRUD

    public User addUser(User user) {
        user.setUsername();
        return repository.save(user);

    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserByUsername(String username) {
        return repository.findOneByUsername(username).get();
    }

    public List<User> getAddressByUsername(String username) {
        return repository.getAddressesByUsername(username);
    }


    public User updateUser(User userrequest) {
        User existingUser = repository.findOneByUsername(userrequest.getUsername()).get();
        existingUser.setAddress(userrequest.getAddress());
        return repository.save(existingUser);
    }
   
    public String deleteUser(String username) {
        repository.deleteUser(username);
        return username+" user deleted";
    }



}
