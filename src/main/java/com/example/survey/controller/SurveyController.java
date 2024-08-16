package com.example.survey.controller;

import com.example.survey.entity.SurveyResponse;
import com.example.survey.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // 설문 응답 저장
    @PostMapping("/responses")
    public ResponseEntity<SurveyResponse> submitResponse(@RequestBody SurveyResponse response) {
        SurveyResponse savedResponse = surveyService.saveResponse(response);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }

    // 모든 설문 응답 조회
    @GetMapping("/responses")
    public ResponseEntity<List<SurveyResponse>> getAllResponses() {
        List<SurveyResponse> responses = surveyService.getAllResponses();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
