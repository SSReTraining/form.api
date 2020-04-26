package com.ss.retraining.service;

import com.ss.retraining.dto.ChoiceOptionsDTO;
import com.ss.retraining.entity.ChoiceOptions;
import com.ss.retraining.repository.ChoiceOptionsRepository;

import java.util.List;

public interface ChoiceOptionsService {
    List<ChoiceOptionsDTO> getAllChoiceOptions();
    ChoiceOptionsDTO getByChoiceOptionsId(Long id);
    void createChoiceOptions(ChoiceOptionsDTO choiceOptionsDTO);
    void deleteChoiceOptionsById(Long id);
    void updateChoiceOptions(ChoiceOptionsDTO choiceOptionsDTO);

}
