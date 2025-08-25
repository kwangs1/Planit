package io.choi.Planit.org.user.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.mapper.UserMapper;
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
        int result= mapper.join(u);
    }
}
