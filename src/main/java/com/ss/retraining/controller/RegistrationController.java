package com.ss.retraining.controller;

import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @PostMapping("auth/registration")
    public String register(@RequestBody UsersDTO userDTO) {
        usersService.createUsers(userDTO);
        return "Hi " + userDTO.getUsername() + " your registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<UsersDTO> findAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/findUser/{id}")
    public UsersDTO findUser(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<UsersDTO> deleteUser(@PathVariable Long id) {
        usersService.deleteUsersByID(id);
        return usersService.getAllUsers();
    }
}
