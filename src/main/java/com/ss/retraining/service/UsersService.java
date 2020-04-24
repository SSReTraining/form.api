package com.ss.retraining.service;

import com.ss.retraining.entity.Users;

import java.util.List;

public interface UsersService {
    Users getUsersById(Long id);
    List<Users> getAllUsers();
    void createUsers(Users users);
    void deleteUserssByID(Long id);
    void updateUsers(Users users,Long id);
}
