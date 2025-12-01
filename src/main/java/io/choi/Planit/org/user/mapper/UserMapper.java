package io.choi.Planit.org.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.org.user.domain.Users;

@Mapper
public interface UserMapper {

    void join(Users u);

    Users findBySabun(String sabun);
    Users findByName(String name);
    
    Users findByUsers(String name, String sabun);
    int passWordReset(String name, String sabun, String password);
}
