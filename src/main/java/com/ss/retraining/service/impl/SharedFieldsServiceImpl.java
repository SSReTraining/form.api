package com.ss.retraining.service.impl;

import com.ss.retraining.dto.SharedFieldsDTO;
import com.ss.retraining.entity.SharedFields;
import com.ss.retraining.repository.SharedFieldsRepository;
import com.ss.retraining.service.SharedFieldsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SharedFieldsServiceImpl implements SharedFieldsService {

    @Autowired
    SharedFieldsRepository sharedFieldsRepository;

    @Autowired
    ModelMapper modelMapper;

    private SharedFieldsDTO convertToDto(SharedFields sharedFields) {
        SharedFieldsDTO sharedFieldsDTO = modelMapper.map(sharedFields, SharedFieldsDTO.class);
        return sharedFieldsDTO;
    }

    private SharedFields convertToEntity(SharedFieldsDTO sharedFieldsDTO){
    SharedFields sharedFields = modelMapper.map(sharedFieldsDTO, SharedFields.class);

        return sharedFields;
    }

    @Override
    public SharedFieldsDTO getSharedFieldsById(Long id) {
        return convertToDto(sharedFieldsRepository.getOne(id));
    }

    @Override
    public List<SharedFieldsDTO> getAllSharedFields() {
        List<SharedFields> sharedFields = sharedFieldsRepository.findAll();
        return sharedFields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createSharedFields(SharedFieldsDTO sharedFieldsDto) {
        sharedFieldsRepository.save(convertToEntity(sharedFieldsDto));
    }

    @Override
    public void deleteSharedFieldsByID(Long id) {
        sharedFieldsRepository.deleteById(id);
    }

    @Override
    public void updateSharedFields(SharedFieldsDTO sharedFieldsDTO) {
        SharedFields sharedFields = convertToEntity(sharedFieldsDTO);
        sharedFieldsRepository.save(sharedFields);
    }
}
