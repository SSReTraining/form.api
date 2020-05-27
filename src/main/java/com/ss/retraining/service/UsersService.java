package com.ss.retraining.service;

import com.ss.retraining.dto.UserInfoDTO;
import com.ss.retraining.dto.UsersDTO;

import java.util.List;

public interface UsersService {
    UsersDTO getUsersById(Long id);

    List<UsersDTO> getAllUsers();

    void createUsers(UsersDTO usersDTO);

    void deleteUsersByID(Long id);

    void updateUsers(UsersDTO usersDTO);

    UsersDTO getUserByName(String name);

    List<UserInfoDTO> getAllOtherUsers();

    UserInfoDTO getUserInfo();


}
