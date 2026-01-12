package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private int currentId = 1;

    public User createUser(String name) {
        User user = new User(currentId++, name);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();

    }

    public List<String> getAllUserNames(){
        return users.stream().map(user -> user.getName()).toList();
    }
}
