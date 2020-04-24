package com.ss.retraining.controller;

import com.ss.retraining.dto.FormFieldsDTO;
import com.ss.retraining.service.FormFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formfields")
public class FormFieldsController {
    @Autowired
    private FormFieldsService formFieldsService;

    @GetMapping
    public List<FormFieldsDTO> getAllFormFields() {
        return formFieldsService.getAllFormFields();

    }

    @GetMapping("/{id}")
    public FormFieldsDTO getFormFieldsById(@PathVariable("id") Long id ){
        return formFieldsService.getByFormFieldsId(id);
    }

    @PostMapping
    public void createFormFields(@RequestBody FormFieldsDTO formFieldsDTO){
        formFieldsService.createFormFields(formFieldsDTO);

    }
}
