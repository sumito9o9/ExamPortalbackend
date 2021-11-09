package com.example.examportal.services;

import com.example.examportal.entityes.User;
import com.example.examportal.entityes.UserRole;

import java.util.Set;

public interface UserService {
    public User CreateUser(User user, Set<UserRole> userRoles) throws Exception;

    public User findUser(String username);

    public String Delete(Integer id);
}
