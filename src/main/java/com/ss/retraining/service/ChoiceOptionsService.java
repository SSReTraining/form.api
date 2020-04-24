package com.ss.retraining.service;

import com.ss.retraining.entity.ChoiceOptions;
import com.ss.retraining.repository.ChoiceOptionsRepository;

import java.util.List;

public interface ChoiceOptionsService {
    List<ChoiceOptions> getAllChoiceOptions();
    ChoiceOptions getByChoiceOptionsId(Long id);
    void createChoiceOptions(ChoiceOptions choiceOptions);
    void deleteChoiceOptionsById(Long id);
    void updateChoiceOptions(ChoiceOptions choiceOptions, Long id);

}
