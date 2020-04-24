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
}
