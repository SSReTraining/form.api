package com.ss.retraining.controller;

import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.SharedFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SharedFieldsController {
    @Autowired
    SharedFieldsService  sharedFieldsService;

    @GetMapping("/shared_fields/{field_id}/user")
    public List<UsersDTO> allUsersWithSharedField(@PathVariable("field_id") Long id){
        return sharedFieldsService.getUsersWithSharedField(id);
    }

    @DeleteMapping("/shared_fields/{field_id}/user/{user_id}")
    public void deleteByUserIdandFieldId(@PathVariable("field_id") Long fieldId,@PathVariable("user_id") Long userId){
        sharedFieldsService.deleteByUserIdAndField(fieldId,userId);
    }
}
