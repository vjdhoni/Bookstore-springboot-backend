package com.apiplatform.bookstore.respositories;

import com.apiplatform.bookstore.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    UserModel findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
}
