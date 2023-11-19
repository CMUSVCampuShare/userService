
package com.campushare.userservice.repository;

import com.campushare.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

   /*
    * public List<User> getAddressesByUsername(String username) {
    * }
    */

   User findByUsername(String username);

   User deleteByUsername(String username);
}
