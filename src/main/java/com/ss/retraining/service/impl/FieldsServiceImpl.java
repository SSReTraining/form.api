package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.entity.Fields;
import com.ss.retraining.repository.FieldsRepository;
import com.ss.retraining.service.FieldsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FieldsServiceImpl implements FieldsService {
    @Autowired
    FieldsRepository fieldsRepository;
    @Autowired
    ModelMapper modelMapper;

    private FieldsDTO convertToDto(Fields fields) {
        FieldsDTO fieldsDTO = modelMapper.map(fields, FieldsDTO.class);
        return fieldsDTO;
    }
    private Fields convertToEntity(FieldsDTO fieldsDTO){
        Fields fields = modelMapper.map(fieldsDTO, Fields.class);
        return fields;
    }
    @Override
    public List<FieldsDTO> getAllFields() {
        List<Fields> fields = fieldsRepository.findAll();
        return fields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FieldsDTO getByFieldsId(Long id) {
        return convertToDto(fieldsRepository.getOne(id));
    }

    @Override
    public void createFields(FieldsDTO fieldsDTO) {
        fieldsRepository.save(convertToEntity(fieldsDTO));
    }

    @Override
    public void deleteFieldsById(Long id) {
        fieldsRepository.deleteById(id);
    }

    @Override
    public void updateFields(FieldsDTO fieldsDTO) {
        Fields fields = convertToEntity(fieldsDTO);
        fieldsRepository.save(fields);

    }

    }

