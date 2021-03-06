package com.ss.retraining.controller;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.dto.FormFieldsDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.Users;
import com.ss.retraining.service.FormFieldsService;
import com.ss.retraining.service.UsersService;
import com.ss.retraining.service.impl.FieldsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/formfields")
public class FormFieldsController {
    @Autowired
    private UsersService usersService;


    @Autowired
    private FormFieldsService formFieldsService;

    @GetMapping
    public List<FormFieldsDTO> getAllFormFields() {

        return formFieldsService.getAllFormFields();

    }

    @GetMapping("/{id}")
    public FormFieldsDTO getFormFieldsById(@PathVariable("id") Long id) {
        return formFieldsService.getByFormFieldsId(id);
    }

    @PostMapping
    public void createFormFields(@RequestBody FormFieldsDTO formFieldsDTO) {
        formFieldsService.createFormFields(formFieldsDTO);

    }

    @PostMapping("/forms/{form_id}/fields")
    public void addFieldsToAForm(@PathVariable("form_id") Long id, @RequestBody FormFieldsDTO formFieldsDTO) {
        formFieldsDTO.setFormId(id);
        System.out.println(formFieldsDTO);
        formFieldsService.createFormFields(formFieldsDTO);
    }

    @GetMapping("/forms/{form_id}/fields")
    public List<FieldDTO> getAllFieldsByFormID(@PathVariable("form_id") Long id) {
        return formFieldsService.getAllFieldsByFormID(id);
    }

    @GetMapping("/forms/{form_id}/fields/{form_field_id}")
    public FieldDTO gitFieldFromAFrom(@PathVariable("form_id") Long formId, @PathVariable("form_field_id") Long formFieldId) {
        return formFieldsService.getFieldFromAForm(formId, formFieldId);
    }

    @PutMapping("/forms/{form_id}/fields/{form_field_id}")
    public void updateFieldWithinAForm(@PathVariable("form_id") Long formId,
                                       @PathVariable("form_field_id") Long formFieldId,
                                       @RequestBody FormFieldsDTO formFieldsDTO) {
        formFieldsDTO.setFormId(formId);
        formFieldsDTO.setId(formFieldId);
        formFieldsService.updateFormFields(formFieldsDTO);

    }

    @DeleteMapping("/forms/{form_id}/fields/{form_field_id}")
    public void deleteByFormFieldId(@PathVariable("form_field_id") Long formFieldId) {
        formFieldsService.deleteFormFieldsById(formFieldId);
    }

}
