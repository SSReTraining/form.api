package com.ss.retraining.service.impl;

import com.ss.retraining.entity.FormFields;
import com.ss.retraining.repository.FormFieldsRepository;
import com.ss.retraining.service.FormFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormFieldsServiceImpl implements FormFieldsService {
    @Autowired
    FormFieldsRepository formFieldsRepository;

    @Override
    public FormFields getById(Long id) {
        return formFieldsRepository.getOne(id);
    }

    @Override
    public void createFormFields(FormFields formFields) {
        formFieldsRepository.save(formFields);
    }
}
