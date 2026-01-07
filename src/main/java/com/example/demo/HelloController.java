package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

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
    public Map<String,Object> getUser(@PathVariable int id)
    {
        Map<String,Object> user=new HashMap<>();
        user.put("id",id);
        user.put("name", "User"+id);
        return user;
    }
}