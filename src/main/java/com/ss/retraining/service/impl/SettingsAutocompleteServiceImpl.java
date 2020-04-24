package com.ss.retraining.service.impl;

import com.ss.retraining.entity.SettingsAutocomplete;
import com.ss.retraining.repository.SettingsAutocompleteRepository;
import com.ss.retraining.service.SettingsAutocompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SettingsAutocompleteServiceImpl implements SettingsAutocompleteService {

    @Autowired
    SettingsAutocompleteRepository settingsAutocompleteRepository;

    @Override
    public List<SettingsAutocomplete> getAllSettingsAutocomplete() {
        return settingsAutocompleteRepository.findAll();
    }

    @Override
    public SettingsAutocomplete getBySettingsAutocompleteId(Long id) {
        return settingsAutocompleteRepository.getOne(id);
    }

    @Override
    public void createSettingsAutocomplete(SettingsAutocomplete settingsAutocomplete) {
        settingsAutocompleteRepository.save(settingsAutocomplete);
    }

    @Override
    public void deleteSettingsAutocompleteById(Long id) {
        settingsAutocompleteRepository.deleteById(id);
    }

    @Override
    public void updateSettingsAutocomplete(SettingsAutocomplete settingsAutocomplete, Long id) {
        SettingsAutocomplete oldSettingsAutocomplete = getBySettingsAutocompleteId(id);
        settingsAutocomplete.setId(oldSettingsAutocomplete.getId());
        createSettingsAutocomplete(settingsAutocomplete);
    }
}
