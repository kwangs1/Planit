package io.choi.Planit.org.user.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    
    private final UserService service;

    @GetMapping("/loginForm")
    public String LoginForm() {
        return "/org/user/loginForm";
    }
    
    @GetMapping("/joinForm")
    public String joinForm() {
        return "org/user/joinForm";
    }

    @PostMapping("/join")
    public String join(Users u) {
        service.join(u);
        return "redirect:/users/loginForm";
    }
    

}
