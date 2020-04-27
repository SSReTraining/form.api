package com.ss.retraining.dto;

import lombok.Data;

import java.security.Timestamp;
@Data
public class FieldDTO {

    private Long id;

    private String name;

    private int fieldType;

    private Boolean isStrict;

    private Timestamp created;

    private Long ownersId;
}
