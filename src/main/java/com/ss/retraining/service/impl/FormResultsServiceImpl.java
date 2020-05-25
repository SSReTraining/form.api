package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FormsResultsDTO;
import com.ss.retraining.entity.FormsResults;
import com.ss.retraining.exception.FormResultsNotFoundException;
import com.ss.retraining.repository.FormFieldsRepository;
import com.ss.retraining.repository.FormResultsRepository;
import com.ss.retraining.repository.FormsRepository;
import com.ss.retraining.repository.UsersRepository;
import com.ss.retraining.service.FormsResultsService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormResultsServiceImpl implements FormsResultsService {
    @Autowired
    FormResultsRepository formResultsRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FormFieldsRepository formFieldsRepository;
    @Autowired
    FormsRepository formsRepository;
    @Autowired
    UsersRepository usersRepository;

    private FormsResultsDTO convertToDto(FormsResults formsResults) {
        FormsResultsDTO formsResultsDTO = modelMapper.map(formsResults,FormsResultsDTO.class);
        formsResultsDTO.setUserId(formsResults.getOwners().getId());
        return formsResultsDTO;
    }

    private FormsResults convertToEntity(FormsResultsDTO formsResultsDTO) {
        FormsResults formsResults = modelMapper.map(formsResultsDTO, FormsResults.class);
        return formsResults;
    }

    @Override
    public List<FormsResultsDTO> getAllFormsResults() {
        return null;
    }

    @Override
    public FormsResultsDTO getByFormsResultsId(Long id) {
        return convertToDto(formResultsRepository.getOne(id));
    }

    @Override
    public void createFormsResults(Long formId,List<String> answers) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<String> questions = new ArrayList<>();
        formFieldsRepository.getAllByFormEntity_Id(formId).forEach(item -> questions.add(item.getQuestion()));
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<answers.size();i++){
            JSONObject jo = new JSONObject();
            try {
                jo.put("question", questions.get(i));
                jo.put("answer", answers.get(i));
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(jo);
        }
        FormsResults formsResults = new FormsResults();
        formsResults.setCreated(LocalDateTime.now());
        formsResults.setForms(formsRepository.getOne(formId));
        formsResults.setOwners(usersRepository.findByUsername(currentPrincipalName));
        formsResults.setAnswers(jsonArray.toString());
        formResultsRepository.save(formsResults);
    }

    @Override
    public void deleteFormsResultsById(Long id) {

    }

    @Override
    public void updateFormsResults(FormsResultsDTO formsResultsDTO) {

    }

    @Override
    public List<FormsResultsDTO> getAllAnswersForAFrom(Long id) {
        List<FormsResults> formsResultsDTOS = formResultsRepository.getAllByForms_Id(id);
        if (formsResultsDTOS.isEmpty()){
                throw new FormResultsNotFoundException("Answers Not Found");
        }
        else {
            return formsResultsDTOS.stream().map(this::convertToDto).collect(Collectors.toList());
        }
    }


}
