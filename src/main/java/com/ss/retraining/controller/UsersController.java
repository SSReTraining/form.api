package com.ss.retraining.controller;

import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    UsersService usersService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UsersDTO userDto) {
        usersService.createUsers(userDto);
    }

//    @PreAuthorize("hasRole('USER')")
//    @PutMapping
//    public void updateUser(@RequestBody UsersDTO userDto, Principal principal) {
//        usersService.updateUser(userConverter.convertToEntity(userDto), principal);
//    }


    @GetMapping("/{id}")
    public UsersDTO getUser(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUsersByID(id);
    }

//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/me")
//    public UsersDTO getCurrentUser(Principal principal) {
//        return userService.getUser(principal));
//    }

}
