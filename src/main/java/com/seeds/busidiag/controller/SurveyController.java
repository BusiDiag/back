package com.seeds.busidiag.controller;

import com.seeds.busidiag.dto.CreateSurveyResultDto;
import com.seeds.busidiag.dto.UpdateSurveyResultDto;
import com.seeds.busidiag.entity.SurveyResult;
import com.seeds.busidiag.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/result")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody @Validated CreateSurveyResultDto createSurveyResultDto) {
        int result = surveyService.save(createSurveyResultDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body("Result Created");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SurveyResult> findById(Long id) {
        SurveyResult result = surveyService.findById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(UpdateSurveyResultDto updateSurveyResultDto, Long id) {
        surveyService.updateById(updateSurveyResultDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Result Updated");
    }

    @GetMapping("/findAll")
    public ResponseEntity<ArrayList<SurveyResult>> findAll(Long page, Long offset) {
        ArrayList<SurveyResult> result = surveyService.findAll(page, offset);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(Long id) {
        surveyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Result Deleted");
    }
}
