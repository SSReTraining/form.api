package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.Forms;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormFieldsDTO {

    private Long id;

    private String question;

    private int position;

    private Forms formEntity;

    private Fields fieldsEntity;

}
