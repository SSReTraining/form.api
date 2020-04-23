package com.ss.retraining.service.impl;

import com.ss.retraining.entity.SharedFields;
import com.ss.retraining.repository.SharedFieldsRepository;
import com.ss.retraining.service.SharedFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SharedFieldsServiceImpl implements SharedFieldsService {

    @Autowired
    SharedFieldsRepository sharedFieldsRepository;

    @Override
    public SharedFields getSharedFieldsById(Long id) {
        return sharedFieldsRepository.getOne(id);
    }

    @Override
    public List<SharedFields> getAllSharedFields() {
        return sharedFieldsRepository.findAll();
    }

    @Override
    public void createSharedFields(SharedFields sharedFields) {
        sharedFieldsRepository.save(sharedFields);
    }

    @Override
    public void deleteSharedFieldsByID(Long id) {
        sharedFieldsRepository.deleteById(id);
    }

    @Override
    public void updateSharedFields(SharedFields sharedFields, Long id) {
        SharedFields sharedFieldsOld = getSharedFieldsById(id);
        sharedFields.setId(sharedFieldsOld.getId());
        createSharedFields(sharedFields);
    }
}
