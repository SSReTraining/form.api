package com.ss.retraining.service.impl;

import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.Users;
import com.ss.retraining.repository.UsersRepository;
import com.ss.retraining.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ModelMapper modelMapper;

    public UsersDTO convertToDto(Users users) {
        UsersDTO usersDTO = modelMapper.map(users, UsersDTO.class);
        return usersDTO;
    }

    public Users convertToEntity(UsersDTO usersDTO) {
        Users users = modelMapper.map(usersDTO, Users.class);
        return users;
    }


    @Override
    public UsersDTO getUsersById(Long id) {
        return convertToDto(usersRepository.getOne(id));
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createUsers(UsersDTO usersDTO) {
        usersRepository.save(convertToEntity(usersDTO));
    }

    @Override
    public void deleteUsersByID(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void updateUsers(UsersDTO usersDTO) {
        Users users = convertToEntity(usersDTO);
        usersRepository.save(users);
    }
}
