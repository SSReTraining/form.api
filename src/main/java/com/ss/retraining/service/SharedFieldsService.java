package com.ss.retraining.service;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.dto.SharedFieldsDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.FormFields;
import com.ss.retraining.entity.SharedFields;

import java.util.List;

public interface SharedFieldsService {
    List<FieldDTO> fieldsThatWereShared();
    SharedFieldsDTO getSharedFieldsById(Long id);
    List<SharedFieldsDTO> getAllSharedFields();
    void createSharedFields(SharedFieldsDTO sharedFields);
    void deleteSharedFieldsByID(Long id);
    void updateSharedFields(SharedFieldsDTO sharedFields);
    List<UsersDTO> getUsersWithSharedField(Long fieldId);
    void deleteByUserIdAndField(Long fieldId,Long userId);

}
