package com.ss.retraining.dto;

import com.ss.retraining.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FormsResultsDTO {
    private Long id;
    private String answers;
    private LocalDateTime created;
    private Users users;

}
