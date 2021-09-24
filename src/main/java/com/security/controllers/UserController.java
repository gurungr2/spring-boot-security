package com.security.controllers;

import com.security.models.User;
import com.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //all users
    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //return single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //Add user
    @PostMapping("/")
    public User add(@RequestBody User user) {
        return this.userService.addUser(user);
    }
}
