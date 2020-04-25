package com.ss.retraining.dto;

import com.ss.retraining.entity.Fields;

public class ChoiceOptionsDTO {
    private long id;

    private String optionText;

    private Fields fields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
