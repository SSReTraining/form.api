package com.ss.retraining.service;

import com.ss.retraining.entity.SettingsAutocomplete;

import java.util.List;

public interface SettingsAutocompleteService {
    List<SettingsAutocomplete> getAllSettingsAutocomplete();
    SettingsAutocomplete getBySettingsAutocompleteId(Long id);
    void createSettingsAutocomplete(SettingsAutocomplete settingsAutocomplete);
    void deleteSettingsAutocompleteById(Long id);
    void updateSettingsAutocomplete(SettingsAutocomplete settingsAutocomplete, Long id);
}