package com.ss.retraining.service;

import com.ss.retraining.entity.FormFields;

public interface FormFieldsService {
    FormFields getById(Long id);
    void createFormFields(FormFields formFields);
}
