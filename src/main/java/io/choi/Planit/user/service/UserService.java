package io.choi.Planit.user.service;

import io.choi.Planit.user.domain.Users;

public interface UserService {

    void join(Users u);

    Users findByUsers(String name, String sabun);
    void passWordReset(String name, String sabun, String password);
}
