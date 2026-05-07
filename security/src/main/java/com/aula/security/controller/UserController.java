package com.aula.security.controller;

import com.aula.security.enums.TipoUser;
import com.aula.security.models.User;
import com.aula.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(
            @RequestParam String login,
            @RequestParam String password
    ) {

        if (userRepository.findByLogin(login) != null) {
            return "Usuário já existe";
        }

        String senhaCriptografada = passwordEncoder.encode(password);

        User user = new User(
                login,
                senhaCriptografada,
                TipoUser.User
        );

        userRepository.save(user);

        return "Usuário cadastrado com sucesso";
    }

    @GetMapping("/users")
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{login}")
    public User buscarPorLogin(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @GetMapping("/teste")
    public String testePublico() {
        return "Endpoint público funcionando";
    }


    @GetMapping("/private")
    public String testePrivado() {
        return "Endpoint privado funcionando";
    }
}