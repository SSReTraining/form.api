package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.Forms;


public class FormFieldsDTO {

    private Long id;

    private String question;

    private int position;

    private Forms formEntity;

    private Fields fieldsEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
