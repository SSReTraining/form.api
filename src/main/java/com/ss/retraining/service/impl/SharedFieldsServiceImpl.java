package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FieldsDTO;
import com.ss.retraining.dto.SharedFieldsDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.SharedFields;
import com.ss.retraining.entity.Users;
import com.ss.retraining.exception.SharedFieldsNotFoundException;
import com.ss.retraining.repository.SharedFieldsRepository;
import com.ss.retraining.service.SharedFieldsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SharedFieldsServiceImpl implements SharedFieldsService {

    @Autowired
    SharedFieldsRepository sharedFieldsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    FieldsServiceImpl fieldsService;

    private SharedFieldsDTO convertToDto(SharedFields sharedFields) {
        SharedFieldsDTO sharedFieldsDTO = modelMapper.map(sharedFields, SharedFieldsDTO.class);
        return sharedFieldsDTO;
    }

    private SharedFields convertToEntity(SharedFieldsDTO sharedFieldsDTO){
    SharedFields sharedFields = modelMapper.map(sharedFieldsDTO, SharedFields.class);
//        sharedFields.setFieldsEntity(fieldsService.convertToEntity(fieldsService.getByFieldsId(sharedFieldsDTO.getFieldsEntity())));
//        sharedFields.setUsers(usersService.convertToEntity(usersService.getUsersById(sharedFieldsDTO.getUsers())));
//        sharedFields.setOwners(usersService.convertToEntity(usersService.getUsersById(sharedFieldsDTO.getOwners())));
        return sharedFields;
    }

    @Override
    public List<FieldDTO> fieldsThatWereShared() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<FieldDTO> fieldsDTOS = new ArrayList<>();
        List<SharedFields> sharedFields = sharedFieldsRepository.getAllByFieldsEntity_Owners_Id(usersService.getUserByName(currentPrincipalName).getId());
        sharedFields.forEach(item->fieldsDTOS.add(fieldsService.convertToDto(item.getFieldsEntity())));
        return fieldsDTOS;
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
    @Override
    public List<UsersDTO> getUsersWithSharedField(Long fieldId){
      List<SharedFields> sharedFields =  sharedFieldsRepository.getAllByFieldsEntity_Id(fieldId);
        List<UsersDTO> usersDTOS = new ArrayList<>();
      sharedFields.forEach(sharedfield -> usersDTOS.add(usersService.convertToDto(sharedfield.getUsers())));
        return usersDTOS;

    }
    @Override
    public void deleteByUserIdAndField(Long fieldId,Long userId){
      sharedFieldsRepository.delete(sharedFieldsRepository.getByFieldsEntity_IdAndAndUsers_Id(fieldId,userId));
    }

    @Override
    public void shareFieldToListOfUsers(Long fieldId, List<Long> usersDTOS) {

        List<SharedFieldsDTO> sharedFieldsDTOS = new ArrayList<>();
        for (Long id : usersDTOS){
            SharedFieldsDTO sharedFieldsDTO = new SharedFieldsDTO();
            sharedFieldsDTO.setUsers(id);
            sharedFieldsDTO.setFieldsEntity(fieldId);
            sharedFieldsDTO.setOwners(fieldsService.getByFieldsId(fieldId).getOwnersId());
            sharedFieldsDTOS.add(sharedFieldsDTO);
        }
        sharedFieldsDTOS.forEach(sharedFieldsDTO -> sharedFieldsRepository.saveByIds
                (sharedFieldsDTO.getFieldsEntity(),sharedFieldsDTO.getOwners(),sharedFieldsDTO.getUsers()));

    }
}
