package com.ss.retraining.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
public class FieldDTO {

    private Long id;

    private String name;

    private int fieldType;

    private Boolean isStrict;

    private LocalDateTime created;

    private Long ownersId;
}
