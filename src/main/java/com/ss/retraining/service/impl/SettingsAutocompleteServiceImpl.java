package com.ss.retraining.service.impl;

import com.ss.retraining.dto.SettingsAutocompleteDTO;
import com.ss.retraining.entity.SettingsAutocomplete;
import com.ss.retraining.repository.SettingsAutocompleteRepository;
import com.ss.retraining.service.SettingsAutocompleteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SettingsAutocompleteServiceImpl implements SettingsAutocompleteService {

    @Autowired
    SettingsAutocompleteRepository settingsAutocompleteRepository;

    @Autowired
    ModelMapper modelMapper;

    private SettingsAutocompleteDTO convertToDTO(SettingsAutocomplete settingsAutocomplete){
        return modelMapper.map(settingsAutocomplete, SettingsAutocompleteDTO.class);
    }

    private SettingsAutocomplete convertToEntity(SettingsAutocompleteDTO settingsAutocompleteDTO){
        return modelMapper.map(settingsAutocompleteDTO, SettingsAutocomplete.class);
    }

    @Override
    public List<SettingsAutocompleteDTO> getAllSettingsAutocomplete() {
        List<SettingsAutocomplete> settingsAutocompletes = settingsAutocompleteRepository.findAll();
        return settingsAutocompletes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SettingsAutocompleteDTO getBySettingsAutocompleteId(Long id) {
        return convertToDTO(settingsAutocompleteRepository.getOne(id));
    }

    @Override
    public void createSettingsAutocomplete(SettingsAutocompleteDTO settingsAutocompleteDTO) {
        settingsAutocompleteRepository.save(convertToEntity(settingsAutocompleteDTO));
    }

    @Override
    public void deleteSettingsAutocompleteById(Long id) {
        settingsAutocompleteRepository.deleteById(id);
    }

    @Override
    public void updateSettingsAutocomplete(SettingsAutocompleteDTO settingsAutocompleteDTO) {
        SettingsAutocomplete settingsAutocomplete = convertToEntity(settingsAutocompleteDTO);
        settingsAutocompleteRepository.save(settingsAutocomplete);
    }
}
