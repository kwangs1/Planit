package io.choi.Planit.org.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.service.UserService;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService service;

    @GetMapping("/loginForm")
    public String LoginForm() {
        return "/org/user/loginForm";
    }

    @PostMapping("/login")
    public void login(String sabun) {
        
    }
    
    @PostMapping("/logout")
    public void logout() {

    }
    
    
    @GetMapping("/joinForm")
    public String joinForm() {
        return "/org/user/joinForm";
    }

    @PostMapping("/join")
    public void join(Users u) {
        
    }
    
    
}
