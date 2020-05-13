package com.ss.retraining.controller;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.service.SharedFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController("/shared_fields")
public class SharedFieldsController {
    @Autowired
    SharedFieldsService  sharedFieldsService;

    @GetMapping
    public List<FieldDTO> allFieldsThatWereSharedByUser(){
        return sharedFieldsService.fieldsThatWereShared();
    }

    @GetMapping("/{field_id}/user")
    public List<UsersDTO> allUsersWithSharedField(@PathVariable("field_id") Long id){
        return sharedFieldsService.getUsersWithSharedField(id);
    }

    @DeleteMapping("/{field_id}/user/{user_id}")
    public void deleteByUserIdandFieldId(@PathVariable("field_id") Long fieldId,@PathVariable("user_id") Long userId){
        sharedFieldsService.deleteByUserIdAndField(fieldId,userId);
    }

    @PostMapping
    public void shareFieldToListOfUsers(@RequestParam Long filedId,@RequestBody List<Long> longs){
        sharedFieldsService.shareFieldToListOfUsers(filedId,longs);
    }
}
