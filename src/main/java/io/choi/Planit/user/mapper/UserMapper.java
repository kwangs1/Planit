package io.choi.Planit.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.user.domain.Users;

@Mapper
public interface UserMapper {

    void join(Users u);

    Users findBySabun(String sabun);
    
    Users findByUsers(String name, String sabun);
    int passWordReset(String name, String sabun, String password);
}
