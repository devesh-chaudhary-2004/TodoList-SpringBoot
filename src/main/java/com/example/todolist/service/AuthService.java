package com.example.todolist.service;

import com.example.todolist.dto.LoginRequestDto;
import com.example.todolist.dto.RegisterRequestDto;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public String register(RegisterRequestDto request){
        User user = new User(
                request.name,
                request.email,
                encoder.encode(request.password)
        );
        userRepository.save(user);
        return "User Registered Successfully";
    }

    public User login(LoginRequestDto request){
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!encoder.matches(request.password, user.getPassword()))
            throw new RuntimeException("Invalid Password");

        return user;
    }
}

