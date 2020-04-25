package com.ss.retraining.service.impl;

import com.ss.retraining.entity.Range;
import com.ss.retraining.repository.RangeRepository;
import com.ss.retraining.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RangeServiceImpl implements RangeService {

    @Autowired
    RangeRepository rangeRepository;

    @Override
    public Range getRangeById(Long id) {
        return rangeRepository.getOne(id);
    }

    @Override
    public List<Range> getAllRanges() {
        return rangeRepository.findAll();
    }

    @Override
    public void createRange(Range range) {
        rangeRepository.save(range);
    }

    @Override
    public void deleteRangeById(Long id) {
        rangeRepository.deleteById(id);
    }
}