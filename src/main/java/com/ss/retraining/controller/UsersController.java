package com.ss.retraining.controller;

import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/registration")
    public void createTest(@RequestBody UsersDTO usersDTO){
        usersService.createUsers(usersDTO);
    }

    @GetMapping("/logout")
    public  String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/swagger-ui.html";
    }
}
