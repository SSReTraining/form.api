package com.ss.retraining.service;

import com.ss.retraining.dto.SettingsAutocompleteDTO;

import java.util.List;

public interface SettingsAutocompleteService {
    List<SettingsAutocompleteDTO> getAllSettingsAutocomplete();
    SettingsAutocompleteDTO getBySettingsAutocompleteId(Long id);
    void createSettingsAutocomplete(SettingsAutocompleteDTO SettingsAutocompleteDTO);
    void deleteSettingsAutocompleteById(Long id);
    void updateSettingsAutocomplete(SettingsAutocompleteDTO settingsAutocompleteDTO);
}
