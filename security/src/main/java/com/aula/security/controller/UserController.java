package com.aula.security.controller;

import com.aula.security.models.User;
import com.aula.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User criarUser(@RequestBody User user){
        return userService.criarUser(user);
    }

}