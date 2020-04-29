package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import lombok.Data;

@Data
public class ChoiceOptionsDTO {
    private Long id;

    private String optionText;

    private Fields fields;
}
