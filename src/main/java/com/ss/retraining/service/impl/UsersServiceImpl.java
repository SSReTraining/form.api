package com.ss.retraining.service.impl;

import com.ss.retraining.dto.UserInfoDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.Users;
import com.ss.retraining.repository.UsersRepository;
import com.ss.retraining.service.UsersService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService,UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ModelMapper modelMapper;

    public UsersDTO convertToDto(Users users) {
        UsersDTO usersDTO = modelMapper.map(users, UsersDTO.class);
        return usersDTO;
    }

    public UserInfoDTO convertToDtoInfo(Users users) {
        UserInfoDTO usersDTO = modelMapper.map(users, UserInfoDTO.class);
        usersDTO.setId(users.getId());
        usersDTO.setUsername(users.getUsername());
        return usersDTO;
    }

    public Users convertToEntity(UsersDTO usersDTO) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(usersDTO.getPassword(), salt);
        Users users = modelMapper.map(usersDTO, Users.class);
        users.setPassword(hashed_password);
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

    @Override
    public UsersDTO getUserByName(String name) {
        return convertToDto(usersRepository.findByUsername(name));
    }

    @Override
    public List<UserInfoDTO> getAllOtherUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Users usersDTO = usersRepository.findByUsername(currentPrincipalName);
        List<Users> usersList = usersRepository.findAll();
        usersList.remove(usersDTO);
        return usersList.stream()
                .map(this::convertToDtoInfo)
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoDTO getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Users usersDTO = usersRepository.findByUsername(currentPrincipalName);
        return convertToDtoInfo(usersDTO);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersDTO usersDTO =convertToDto(usersRepository.findByUsername(s)) ;
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(usersDTO.getUsername(), usersDTO.getPassword(),authorities);
    }


    private SessionFactory sessionFactory;



}
