package com.ss.retraining.controller;

import com.ss.retraining.dto.UserInfoDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UsersController {


    @Autowired
    UsersService usersService;

    @GetMapping("/allother")
    public List<UserInfoDTO> getAllOtherUsers(){
        return usersService.getAllOtherUsers();
    }

    @GetMapping("/current")
    public UserInfoDTO getCurrent(){
        return usersService.getUserInfo();
    }

    @PostMapping("/registration/")
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
