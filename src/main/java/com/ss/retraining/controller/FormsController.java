package com.ss.retraining.controller;


import com.ss.retraining.dto.FormsDto;
import com.ss.retraining.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormsController {
    @Autowired
    private FormsService formsService;

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
