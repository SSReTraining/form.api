package com.ss.retraining.dto;

import lombok.Data;

@Data
public class CreateFormFieldsDTO {
    private Long fieldId;
    private String question;
    private int position;
}
