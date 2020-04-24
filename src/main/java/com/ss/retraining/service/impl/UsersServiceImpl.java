package com.ss.retraining.service.impl;

import com.ss.retraining.entity.Users;
import com.ss.retraining.repository.UsersRepository;
import com.ss.retraining.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users getUsersById(Long id) {
        return usersRepository.getOne(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void createUsers(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUserssByID(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void updateUsers(Users users, Long id) {
        Users usersOld = getUsersById(id);
        users.setId(usersOld.getId());
        createUsers(users);
    }
}
