package com.example.demo;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from backend";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/greet")
    public Map<String,String> greet(@RequestParam String name)
    {
        Map<String, String > r=new HashMap<>();
        r.put("message",name);
        return r;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody UserRequest request) {
        return userService.createUser(request.getName());
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user-names")
    public List<String> getUserNames() {
        return userService.getAllUserNames();
    }
}