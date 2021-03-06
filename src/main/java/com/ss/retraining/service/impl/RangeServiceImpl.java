package com.ss.retraining.service.impl;

import com.ss.retraining.dto.RangeDTO;
import com.ss.retraining.entity.Ranges;
import com.ss.retraining.repository.RangeRepository;
import com.ss.retraining.service.RangeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RangeServiceImpl implements RangeService {

    @Autowired
    RangeRepository rangeRepository;

    @Autowired
    ModelMapper modelMapper;

    private RangeDTO convertToDTO(Ranges ranges){
        return modelMapper.map(ranges, RangeDTO.class);
    }

    private Ranges convertToEntity(RangeDTO rangeDTO){
        return modelMapper.map(rangeDTO, Ranges.class);
    }

    @Override
    public RangeDTO getRangeById(Long id) {
        return convertToDTO(rangeRepository.getOne(id));
    }

    @Override
    public List<RangeDTO> getAllRanges() {
        List<Ranges> ranges = rangeRepository.findAll();
        return ranges.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void createRange(RangeDTO rangeDTO) {
        rangeRepository.save(convertToEntity(rangeDTO));
    }

    @Override
    public void deleteRangeById(Long id) {
        rangeRepository.deleteById(id);
    }
}
