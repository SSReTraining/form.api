package com.ss.retraining.dto;

import com.ss.retraining.entity.*;

import java.sql.Timestamp;
import java.util.List;

public class FieldsDTO {
    private long id;

    private String name;

    private int fieldType;

    private Boolean isStrict;

    private Timestamp created;

    private List<FormFields> formFields;

    private List<ChoiceOptionsDTO> choiceOptions;

    private List<SharedFields> sharedFields;

    private List<SettingsAutocomplete> settingsAutocomplete;

    private List<Fields> fields;

    private Users owners;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFieldType() {
        return fieldType;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getStrict() {
        return isStrict;
    }

    public void setStrict(Boolean strict) {
        isStrict = strict;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public List<FormFields> getFormFields() {
        return formFields;
    }

    public void setFormFields(List<FormFields> formFields) {
        this.formFields = formFields;
    }

    public List<ChoiceOptionsDTO> getChoiceOptions() {
        return choiceOptions;
    }

    public void setChoiceOptions(List<ChoiceOptionsDTO> choiceOptions) {
        this.choiceOptions = choiceOptions;
    }

    public List<SharedFields> getSharedFields() {
        return sharedFields;
    }

    public void setSharedFields(List<SharedFields> sharedFields) {
        this.sharedFields = sharedFields;
    }

    public List<SettingsAutocomplete> getSettingsAutocomplete() {
        return settingsAutocomplete;
    }

    public void setSettingsAutocomplete(List<SettingsAutocomplete> settingsAutocomplete) {
        this.settingsAutocomplete = settingsAutocomplete;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }

    public Users getOwners() {
        return owners;
    }

    public void setOwners(Users owners) {
        this.owners = owners;
    }
}
