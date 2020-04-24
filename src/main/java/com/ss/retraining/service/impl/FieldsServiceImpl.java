package com.ss.retraining.service.impl;

import com.ss.retraining.entity.Fields;
import com.ss.retraining.repository.FieldsRepository;
import com.ss.retraining.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldsServiceImpl implements FieldsService {
@Autowired
    FieldsRepository fieldsRepository;

    @Override
    public List<Fields> getAllFields() {
        return fieldsRepository.findAll();
    }

    @Override
    public Fields getByFieldsId(Long id) {
        return fieldsRepository.getOne(id);
    }

    @Override
    public void createFields(Fields fields) {
    fieldsRepository.save(fields);
    }

    @Override
    public void deleteFieldsById(Long id) {
    fieldsRepository.deleteById(id);
    }

    @Override
    public void updateFields(Fields fields, Long id) {
    Fields field = getByFieldsId(id);
    fields.setId(field.getId());
    createFields(fields);
    }
}
