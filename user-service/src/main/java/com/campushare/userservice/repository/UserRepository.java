
package main.java.com.campushare.userservice.repository;

import com.campushare.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;


public class UserRepository extends MongoRepository<User, String> {
    
   /*  public List<User> getAddressesByUsername(String username) {
    }
     */
}
