package com.ss.retraining.service;

import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.entity.Fields;

import java.util.List;

public interface FieldsService {
    List<FieldsDTO> getAllFields();
    FieldsDTO getByFieldsId(Long id);
    void createFields(FieldsDTO fieldsDTO);
    void deleteFieldsById(Long id);
    void updateFields(FieldsDTO fieldsDTO);

}
