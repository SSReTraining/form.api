package com.ss.retraining.service;

import com.ss.retraining.dto.FormFieldsDTO;
import com.ss.retraining.entity.FormFields;

import java.util.List;

public interface FormFieldsService {
    List<FormFieldsDTO> getAllFormFields();
    FormFieldsDTO getByFormFieldsId(Long id);
    void createFormFields(FormFieldsDTO formFieldsDTO);
    void deleteFormFieldsById(Long id);
    void updateFormFields(FormFieldsDTO formFieldsDTO);
}
