package com.ss.retraining.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
}
