package com.ss.retraining.service;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FormFieldsDTO;

import java.util.List;

public interface FormFieldsService {
    FieldDTO getFieldFromAForm(Long formId, Long formFieldId);

    List<FieldDTO> getAllFieldsByFormID(Long id);

    List<FormFieldsDTO> getAllFormFields();

    FormFieldsDTO getByFormFieldsId(Long id);

    void createFormFields(FormFieldsDTO formFieldsDTO);

    void deleteFormFieldsById(Long id);

    void updateFormFields(FormFieldsDTO formFieldsDTO);

}
