package com.aula.security.service;

import com.aula.security.models.User;
import com.aula.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User criarUser(User user){
        return userRepository.save(user);
    }
}