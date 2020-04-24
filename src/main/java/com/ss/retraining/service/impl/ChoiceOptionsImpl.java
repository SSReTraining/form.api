package com.ss.retraining.service.impl;

import com.ss.retraining.dto.ChoiceOptionsDTO;
import com.ss.retraining.entity.ChoiceOptions;
import com.ss.retraining.repository.ChoiceOptionsRepository;
import com.ss.retraining.service.ChoiceOptionsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChoiceOptionsImpl implements ChoiceOptionsService {
    @Autowired
    ChoiceOptionsRepository choiceOptionsRepository;
    @Autowired
    ModelMapper modelMapper;

    private ChoiceOptionsDTO convertToDto(ChoiceOptions choiceOptions) {
        ChoiceOptionsDTO choiceOptionsDTO = modelMapper.map(choiceOptions, ChoiceOptionsDTO.class);
        return  choiceOptionsDTO;
    }
    private ChoiceOptions convertToEntity(ChoiceOptionsDTO choiceOptionsDTO){
        ChoiceOptions choiceOptions = modelMapper.map(choiceOptionsDTO, ChoiceOptions.class);
        return  choiceOptions;
    }
    @Override
    public List<ChoiceOptionsDTO> getAllChoiceOptions() {
        List<ChoiceOptions> choiceOptions = choiceOptionsRepository.findAll();
        return choiceOptions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChoiceOptionsDTO getByChoiceOptionsId(Long id) {
        return convertToDto(choiceOptionsRepository.getOne(id));
    }

    @Override
    public void createChoiceOptions(ChoiceOptionsDTO choiceOptionsDTO) {
        choiceOptionsRepository.save(convertToEntity(choiceOptionsDTO));
    }

    @Override
    public void deleteChoiceOptionsById(Long id) {
    choiceOptionsRepository.deleteById(id);
    }

    @Override
    public void updateChoiceOptions(ChoiceOptionsDTO choiceOptionsDTO) {
        ChoiceOptions choiceOptions = convertToEntity(choiceOptionsDTO);
        choiceOptionsRepository.save(choiceOptions);

    }

}
