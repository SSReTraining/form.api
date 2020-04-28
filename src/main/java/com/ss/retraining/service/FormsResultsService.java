package com.ss.retraining.service;

import com.ss.retraining.dto.FormsResultsDTO;
import com.ss.retraining.entity.FormsResults;

import java.util.List;

public interface FormsResultsService {
    List<FormsResultsDTO> getAllFormsResults();
    FormsResultsDTO getByFormsResultsId(Long id);
    void createFormsResults(FormsResultsDTO formsResultsDTO);
    void deleteFormsResultsById(Long id);
    void updateFormsResults(FormsResultsDTO formsResultsDTO);
}
