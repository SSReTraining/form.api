package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class SharedFieldsDTO {
    private Long id;

    private Long fieldsEntity;

    private Long users;

    private Long owners;
}
