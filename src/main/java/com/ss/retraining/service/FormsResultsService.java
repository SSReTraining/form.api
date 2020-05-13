package com.ss.retraining.service;

import com.ss.retraining.dto.FormsResultsDTO;
import com.ss.retraining.entity.FormsResults;
import org.json.JSONException;

import java.util.List;

public interface FormsResultsService {
    List<FormsResultsDTO> getAllFormsResults();
    FormsResultsDTO getByFormsResultsId(Long id) ;
    void createFormsResults(Long formId,List<String> answers) throws JSONException;
    void deleteFormsResultsById(Long id);
    void updateFormsResults(FormsResultsDTO formsResultsDTO);
    List<FormsResultsDTO> getAllAnswersForAFrom(Long id);
}
