package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    void deleteUserByFirstName(String firstName);
}
