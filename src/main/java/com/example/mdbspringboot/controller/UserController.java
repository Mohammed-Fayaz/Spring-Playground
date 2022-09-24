package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.model.User;
import com.example.mdbspringboot.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public List<User> addUser(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        userRepository.save(new User(firstName, lastName));
        return getUsers();
    }

    @GetMapping("/delete")
    public List<User> deleteUser (@RequestParam(value = "firstName") String firstName){
        userRepository.deleteUserByFirstName(firstName);
        return getUsers();
    }
}
