package com.ss.retraining.service.impl;

import com.ss.retraining.dto.SharedFieldsDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.SharedFields;
import com.ss.retraining.entity.Users;
import com.ss.retraining.repository.SharedFieldsRepository;
import com.ss.retraining.service.SharedFieldsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
