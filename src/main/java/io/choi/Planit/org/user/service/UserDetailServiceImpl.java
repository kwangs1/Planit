package io.choi.Planit.org.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Users user = mapper.findBySabun(loginId);
        log.info("[INFO]  loadUserByUsername param String loginId > "+loginId);
        if(user == null){
            throw new UsernameNotFoundException("sabun or name not found");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }
        log.info("ROLE = {}", user.getRole());
        return user;
    }
    
}
