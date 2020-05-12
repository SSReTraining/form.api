package com.ss.retraining.controller;

import com.ss.retraining.entity.Users;
import com.ss.retraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@SpringBootApplication
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registr")
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());
        return "registr";
    }

    @PostMapping("/registr")
    public String addUser(@ModelAttribute("userForm") @Valid Users userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registr";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Passwords don`t match");
            return "registr";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "User already exists");
            return "registr";
        }

        return "redirect:/";
    }
}
