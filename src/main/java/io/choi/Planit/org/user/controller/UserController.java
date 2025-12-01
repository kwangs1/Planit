package io.choi.Planit.org.user.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @PostMapping("/findByUsers")
    public ResponseEntity<String> findByUsers(@RequestBody Map<String, String>param){
        String name = param.get("name");
        String sabun = param.get("sabun");
        Users user = service.findByUsers(name, sabun);

        if (user != null){
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("fail");
        }
        
    }
    @PostMapping("/passWordReset")
    public String passWordReset(String name, String sabun, String password){
        service.passWordReset(name, sabun, password);
        return "redirect:/users/loginForm";
    }

}
