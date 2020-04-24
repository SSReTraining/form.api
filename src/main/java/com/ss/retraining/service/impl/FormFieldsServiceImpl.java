package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FormFieldsDTO;
import com.ss.retraining.entity.FormFields;
import com.ss.retraining.repository.FormFieldsRepository;
import com.ss.retraining.service.FormFieldsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FormFieldsServiceImpl implements FormFieldsService {
    @Autowired
    FormFieldsRepository formFieldsRepository;
    @Autowired
    ModelMapper modelMapper;

    private FormFieldsDTO convertToDto(FormFields formFields) {
        FormFieldsDTO sharedFieldsDTO = modelMapper.map(formFields, FormFieldsDTO.class);
        return sharedFieldsDTO;
    }

    private FormFields convertToEntity(FormFieldsDTO formFieldsDTO) {
        FormFields formFields = modelMapper.map(formFieldsDTO, FormFields.class);

        return formFields;
    }

    @Override
    public List<FormFieldsDTO> getAllFormFields() {
        List<FormFields> formFields = formFieldsRepository.findAll();
        return formFields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FormFieldsDTO getByFormFieldsId(Long id) {

        return convertToDto(formFieldsRepository.getOne(id));
    }

    @Override
    public void createFormFields(FormFieldsDTO formFieldsDTO) {
        formFieldsRepository.save(convertToEntity(formFieldsDTO));
    }

    @Override
    public void deleteFormFieldsById(Long id) {
        formFieldsRepository.deleteById(id);
    }

    @Override
    public void updateFormFields(FormFieldsDTO formFieldsDTO) {
        FormFields formFields = convertToEntity(formFieldsDTO);
        formFieldsRepository.save(formFields);

    }
}
