package io.choi.Planit.org.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.org.user.domain.Users;

@Mapper
public interface UserMapper {

    int join(Users u);

    Users findBySabun(String sabun);
    Users findByName(String name);
    
}
