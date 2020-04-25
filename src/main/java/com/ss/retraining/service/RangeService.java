package com.ss.retraining.service;

import com.ss.retraining.entity.Range;

import java.util.List;

public interface RangeService {
    Range getRangeById(Long id);
    List<Range> getAllRanges();
    void createRange(Range range);
    void deleteRangeById(Long id);
}