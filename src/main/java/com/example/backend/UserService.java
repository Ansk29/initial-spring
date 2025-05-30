package com.example.backend;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String addUser(User user) {
        repo.save(user);
        return "User added: " + user.getName();
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public String deleteUser(String name) {
        if (repo.existsById(name)) {
            repo.deleteById(name);
            return "User " + name + " deleted.";
        }
        return "User " + name + " not found.";
    }

    public String updateUser(String name, User updatedUser) {
        if (repo.existsById(name)) {
            repo.save(updatedUser);
            return "User " + name + " updated.";
        }
        return "User " + name + " not found.";
    }
}