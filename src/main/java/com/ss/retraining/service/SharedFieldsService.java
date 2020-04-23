package com.ss.retraining.service;

import com.ss.retraining.entity.FormFields;
import com.ss.retraining.entity.SharedFields;

import java.util.List;

public interface SharedFieldsService {
    SharedFields getSharedFieldsById(Long id);
    List<SharedFields> getAllSharedFields();
    void createSharedFields(SharedFields sharedFields);
    void deleteSharedFieldsByID(Long id);
    void updateSharedFields(SharedFields sharedFields,Long id);

}
