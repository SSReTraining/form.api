package com.ss.retraining.service.impl;

import com.ss.retraining.entity.FormFields;
import com.ss.retraining.repository.FormFieldsRepository;
import com.ss.retraining.service.FormFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormFieldsServiceImpl implements FormFieldsService {
    @Autowired
    FormFieldsRepository formFieldsRepository;

    @Override
    public List<FormFields> getAllFormFields() {
        return formFieldsRepository.findAll();
    }

    @Override
    public FormFields getByFormFieldsId(Long id) {
        return formFieldsRepository.getOne(id);
    }

    @Override
    public void createFormFields(FormFields formFields) {
        formFieldsRepository.save(formFields);
    }

    @Override
    public void deleteFormFieldsById(Long id) {
        formFieldsRepository.deleteById(id);
    }

    @Override
    public void updateFormFields(FormFields formFields,Long id) {
        FormFields formFieldsOld = getByFormFieldsId(id);
        formFields.setId(formFieldsOld.getId());
        createFormFields(formFields);
    }
}
