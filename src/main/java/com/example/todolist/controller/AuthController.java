package com.example.todolist.controller;

import com.example.todolist.dto.LoginRequestDto;
import com.example.todolist.dto.RegisterRequestDto;
import com.example.todolist.model.User;
import com.example.todolist.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDto request){
        return service.register(request);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDto request){
        return service.login(request);
    }
}

