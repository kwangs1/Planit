package io.choi.Planit.org.user.service;

import io.choi.Planit.org.user.domain.Users;

public interface UserService {

    void join(Users u);

    Users findByUsers(String name, String sabun);
    void passWordReset(String name, String sabun, String password);
}
