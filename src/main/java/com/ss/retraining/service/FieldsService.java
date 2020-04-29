package com.ss.retraining.service;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.entity.Fields;

import java.util.List;

public interface FieldsService {
    List<FieldDTO> getAllFields();

    FieldDTO getByFieldsId(Long id);

    void createFields(FieldDTO fieldsDTO);

    void deleteFieldsById(Long id);

    void updateFields(FieldDTO fieldsDTO);

}
