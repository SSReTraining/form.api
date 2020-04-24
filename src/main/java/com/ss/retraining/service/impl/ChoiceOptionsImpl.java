package com.ss.retraining.service.impl;

import com.ss.retraining.entity.ChoiceOptions;
import com.ss.retraining.repository.ChoiceOptionsRepository;
import com.ss.retraining.service.ChoiceOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChoiceOptionsImpl implements ChoiceOptionsService {
    @Autowired
    ChoiceOptionsRepository choiceOptionsRepository;

    @Override
    public List<ChoiceOptions> getAllChoiceOptions() {
        return choiceOptionsRepository.findAll();
    }

    @Override
    public ChoiceOptions getByChoiceOptionsId(Long id) {
        return choiceOptionsRepository.getOne(id);
    }

    @Override
    public void createChoiceOptions(ChoiceOptions choiceOptions) {
        choiceOptionsRepository.save(choiceOptions);
    }

    @Override
    public void deleteChoiceOptionsById(Long id) {
    choiceOptionsRepository.deleteById(id);
    }

    @Override
    public void updateChoiceOptions(ChoiceOptions choiceOptions, Long id) {
        ChoiceOptions choiceOptions1 = getByChoiceOptionsId(id);
        choiceOptions.setId(choiceOptions1.getId());
        createChoiceOptions(choiceOptions);

    }

}
