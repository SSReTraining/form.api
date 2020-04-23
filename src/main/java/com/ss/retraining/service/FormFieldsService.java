package com.ss.retraining.service;

import com.ss.retraining.entity.FormFields;

import java.util.List;

public interface FormFieldsService {
    List<FormFields> getAllFormFields();
    FormFields getByFormFieldsId(Long id);
    void createFormFields(FormFields formFields);
    void deleteFormFieldsById(Long id);
    void updateFormFields(FormFields formFields,Long id);
}
