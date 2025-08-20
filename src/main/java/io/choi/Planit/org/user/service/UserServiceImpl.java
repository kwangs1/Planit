package io.choi.Planit.org.user.service;

import org.springframework.stereotype.Service;

import io.choi.Planit.org.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    
    private final UserMapper mapper;
}
