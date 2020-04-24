package com.ss.retraining.service;

import com.ss.retraining.entity.Fields;

import java.util.List;

public interface FieldsService {
    List<Fields> getAllFields();
    Fields getByFieldsId(Long id);
    void createFields(Fields fields);
    void deleteFieldsById(Long id);
    void updateFields(Fields fields,Long id);

}
