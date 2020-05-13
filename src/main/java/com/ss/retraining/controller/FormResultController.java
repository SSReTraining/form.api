package com.ss.retraining.controller;

import com.ss.retraining.dto.FormsResultsDTO;
import com.ss.retraining.service.FormsResultsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FormResultController  {
@Autowired
    FormsResultsService formsResultsService;

@PostMapping("/forms/{form_id}/answers/")
public void createFormResult(@PathVariable("form_id") Long id, @RequestBody List<String> strings){
    try {
        formsResultsService.createFormsResults(id,strings);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
@GetMapping("/forms/{form_id}/answers")
    public List<FormsResultsDTO> getAllAnswersForAForm(@PathVariable("form_id") Long id){
   return formsResultsService.getAllAnswersForAFrom(id);
}

@GetMapping("/forms/{form_id}/answers/{result_id}")
    public FormsResultsDTO getAnswerForAFrom(@PathVariable("result_id") Long id){
    return formsResultsService.getByFormsResultsId(id);
}

}
