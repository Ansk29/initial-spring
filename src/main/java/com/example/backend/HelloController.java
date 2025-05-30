package com.example.backend;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.*;
import java.util.List;



import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController {


    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/users/{name}")
    public String deleteUser(@PathVariable String name) {
        return userService.deleteUser(name);
    }

    @PutMapping("/users/{name}")
    public String updateUser(@PathVariable String name, @RequestBody User user) {
        return userService.updateUser(name, user);
    }
}
