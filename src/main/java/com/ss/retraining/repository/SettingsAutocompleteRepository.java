package com.ss.retraining.repository;

import com.ss.retraining.entity.SettingsAutocomplete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsAutocompleteRepository extends JpaRepository<SettingsAutocomplete, Long> {

}
