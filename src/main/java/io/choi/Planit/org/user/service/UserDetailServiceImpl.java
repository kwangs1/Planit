package io.choi.Planit.org.user.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import io.choi.Planit.org.user.domain.Users;
import io.choi.Planit.org.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserMapper mapper; 
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Users user = mapper.findBySabun(loginId);

        if(user == null){
            user = mapper.findByName(loginId);
        }
        if(user == null){
            throw new UsernameNotFoundException("sabun or name not found");
        }

        return User.builder()
            .username(user.getSabun())
            .password(user.getPassword())
            .roles("kwangs")
            .build();
    }
    
}
