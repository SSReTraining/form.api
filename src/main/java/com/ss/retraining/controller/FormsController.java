package com.ss.retraining.controller;


import com.ss.retraining.dto.FormsDto;
import com.ss.retraining.entity.FormsResults;
import com.ss.retraining.service.FormsResultsService;
import com.ss.retraining.service.FormsService;
import com.ss.retraining.service.impl.FormResultsServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/forms")
public class FormsController {
    @Autowired
    private FormsService formsService;
    @Autowired
    private FormResultsServiceImpl formResultsService;
    @GetMapping
    public List<FormsDto> getAllForms() {
        return formsService.getAllForms();
    }

    @GetMapping("/{form_id}")
    public FormsDto getFormsById(@PathVariable("form_id") Long id) {
        return formsService.getFormsById(id);
    }

    @PostMapping
    public void createForms(@RequestBody FormsDto formsDto) {
        formsService.createForms(formsDto);
    }

    @DeleteMapping("/{form_id}")
    public void deleteFormById(@PathVariable("form_id") Long id) {
        formsService.deleteFormsById(id);
    }

    @PutMapping("/{form_id}")
    public void updateForms(@PathVariable("form_id") Long id,@RequestBody FormsDto formsDto) {
        formsDto.setId(id);
        formsService.updateForms(formsDto);

    }


}
