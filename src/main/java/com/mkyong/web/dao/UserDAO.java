package com.mkyong.web.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mkyong.web.model.User;

public interface UserDAO extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);

}
