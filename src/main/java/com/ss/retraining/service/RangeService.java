package com.ss.retraining.service;

import com.ss.retraining.dto.RangeDTO;

import java.util.List;

public interface RangeService {
    RangeDTO getRangeById(Long id);
    List<RangeDTO> getAllRanges();
    void createRange(RangeDTO RangeDTO);
    void deleteRangeById(Long id);
}
