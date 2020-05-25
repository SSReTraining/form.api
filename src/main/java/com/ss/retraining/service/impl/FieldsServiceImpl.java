package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.entity.Fields;
import com.ss.retraining.exception.FieldsNotFoundException;
import com.ss.retraining.repository.FieldsRepository;
import com.ss.retraining.service.FieldsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldsServiceImpl implements FieldsService {
    @Autowired
    FieldsRepository fieldsRepository;
    @Autowired
    ModelMapper modelMapper;


    public FieldDTO convertToDto(Fields fields) {
        FieldDTO fieldDTO = modelMapper.map(fields, FieldDTO.class);
        return fieldDTO;
    }

    public Fields convertToEntity(FieldDTO fieldDTO) {
        Fields fields = modelMapper.map(fieldDTO, Fields.class);
        return fields;
    }

    @Override
    public List<FieldDTO> getAllFieldsByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Fields> fields = fieldsRepository.getAllByOwners_Username(currentPrincipalName);
        return fields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FieldDTO> getAllFields() {
        List<Fields> fields = fieldsRepository.findAll();
        return fields.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public FieldDTO getByFieldsId(Long id) {
        final Fields fields =  fieldsRepository.getOne(id);
       try {

           System.out.println(fields.getCreated());
       }
       catch (EntityNotFoundException e){
           throw new FieldsNotFoundException("hhh");
       }
        return convertToDto(fields);
    }

    @Override
    public void createFields(FieldDTO fieldsDTO) {
        fieldsDTO.setCreated(LocalDateTime.now());
        fieldsRepository.save(convertToEntity(fieldsDTO));
    }

    @Override
    public void deleteFieldsById(Long id) {
        fieldsRepository.deleteById(id);
    }

    @Override
    public void updateFields(FieldDTO fieldDTO) {
        Fields fields = convertToEntity(fieldDTO);
        fieldsRepository.save(fields);

    }

}

