package io.choi.Planit.user.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.choi.Planit.user.domain.Users;
import io.choi.Planit.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    
    private final UserMapper mapper; 
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void join(Users u){
        u.setStatus("1");
        LocalDateTime loc = LocalDateTime.now();
        u.setCreateDt(loc);
        String encPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encPassword);
        mapper.join(u);
    }

    @Override
    public Users findByUsers(String name, String sabun){
        return mapper.findByUsers(name, sabun);
    }
    @Override
    public void passWordReset(String name, String sabun, String password) {
        String encPassword = passwordEncoder.encode(password);
        int update = mapper.passWordReset(name, sabun, encPassword);
        if (update == 0){
            throw new RuntimeException("비밀번호 변경 대상이 없습니다.");
        }
    }
    
}
