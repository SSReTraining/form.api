package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.dto.FormFieldsDTO;
import com.ss.retraining.entity.Fields;
import com.ss.retraining.entity.FormFields;
import com.ss.retraining.entity.Forms;
import com.ss.retraining.repository.FieldsRepository;
import com.ss.retraining.repository.FormFieldsRepository;
import com.ss.retraining.repository.FormsRepository;
import com.ss.retraining.service.FormFieldsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("formFieldService")
public class FormFieldsServiceImpl implements FormFieldsService {
    @Autowired
    FormFieldsRepository formFieldsRepository;
    @Autowired
    FormsRepository formsRepository;
    @Autowired
    FieldsRepository fieldsRepository;
    @Autowired
    FieldsServiceImpl fieldsServiceImpl;
    @Autowired
    ModelMapper modelMapper;
    private FormFieldsDTO convertToDto(FormFields formFields) {
        FormFieldsDTO sharedFieldsDTO = modelMapper.map(formFields, FormFieldsDTO.class);
        return sharedFieldsDTO;
    }

    private FormFields convertToEntity(FormFieldsDTO formFieldsDTO) {
        FormFields  formFields = modelMapper.map(formFieldsDTO, FormFields.class);
        formFields.setFieldsEntity(fieldsRepository.getOne(formFieldsDTO.getFieldsId()));
        formFields.setFormEntity(formsRepository.getOne(formFieldsDTO.getFormId()));
        return formFields;
    }

    private FieldDTO convertToFiieldDTO(Fields fields){
        FieldDTO fieldDTO = modelMapper.map(fields,FieldDTO.class);
        return fieldDTO;
    }


    @Override
    public FieldDTO getFieldFromAForm(Long formId, Long formFieldId) {
       FormFields formFields = formFieldsRepository.getByIdAndFormEntity_Id(formFieldId,formId);
        return convertToFiieldDTO(formFields.getFieldsEntity());
    }

    @Override
    public List<FieldDTO> getAllFieldsByFormID(Long id) {
        List<FormFields> formFields = formFieldsRepository.getAllByFormEntity_Id(id);
        List<Fields> fields = new ArrayList<>();
        formFields.forEach(item->fields.add(item.getFieldsEntity()));
       List<FieldDTO> fieldsDTOS = new ArrayList<>();
               fields.forEach(item->fieldsDTOS.add(convertToFiieldDTO(item)));
               fieldsDTOS.forEach(item-> System.out.println(item));
        return fieldsDTOS;
    }

    @Override
    public List<FormFieldsDTO> getAllFormFields() {
        List<FormFields> formFields = formFieldsRepository.findAll();
        return formFields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    SessionFactory sessionFactory;
    @Override
    public FormFieldsDTO getByFormFieldsId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        FormFields formFields = (FormFields)session.get(FormFields.class,id);
        return convertToDto(formFields);
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
