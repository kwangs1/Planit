package io.choi.Planit.org.user.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(Users u){
        u.setDept_id(1);
        u.setDept_name("KSCIT");
        u.setRank_id(1);
        u.setPos_id(1);
        u.setStatus("1");
        LocalDateTime loc = LocalDateTime.now();
        u.setCreate_dt(loc);
        u.setManager_f("1");
        String encPassword = bCryptPasswordEncoder.encode(u.getPassword());
        u.setPassword(encPassword);
        int result= mapper.join(u);
    }
}
