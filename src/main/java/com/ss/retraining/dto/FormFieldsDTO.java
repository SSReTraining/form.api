package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.Forms;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FormFieldsDTO {

    private Long id;

    private String question;

    private int position;

    private Long formId;

    private Long fieldsId;

}
