package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SharedFieldsDTO {
    private Long id;

    private Fields fieldsEntity;

    private Users users;

    private Users owners;
}
