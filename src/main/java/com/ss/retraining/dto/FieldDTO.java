package com.ss.retraining.dto;

import lombok.Data;
import lombok.Setter;

import java.security.Timestamp;
@Data
@Setter
public class FieldDTO {

    private Long id;

    private String name;

    private int fieldType;

    private Boolean isStrict;

    private Timestamp created;

    private Long ownersId;

    public void setField(Long fieldId) {
        this.id = fieldId;
    }
}
