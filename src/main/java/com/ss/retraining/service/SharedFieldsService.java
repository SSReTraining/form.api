package com.ss.retraining.service;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.SharedFieldsDTO;
import com.ss.retraining.dto.UsersDTO;

import java.util.List;

public interface SharedFieldsService {
    List<FieldDTO> fieldsThatWereShared();

    SharedFieldsDTO getSharedFieldsById(Long id);

    List<SharedFieldsDTO> getAllSharedFields();

    void createSharedFields(SharedFieldsDTO sharedFields);

    void deleteSharedFieldsByID(Long id);

    void updateSharedFields(SharedFieldsDTO sharedFields);

    List<UsersDTO> getUsersWithSharedField(Long fieldId);

    void deleteByUserIdAndField(Long fieldId, Long userId);

    void shareFieldToListOfUsers(Long fieldId,List<Long> usersIds);

}
