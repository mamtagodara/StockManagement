package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> getAllTransactions(){
        List<User> users = userRepository.findAll();

        for (User user : users) {
            System.out.println(user); // Print each user's details
        }
        return users;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }
}
