package com.example.survey.service;

import com.example.survey.entity.SurveyResponse;
import com.example.survey.repository.SurveyResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private final SurveyResponseRepository repository;

    public SurveyService(SurveyResponseRepository repository) {
        this.repository = repository;
    }

    public SurveyResponse saveResponse(SurveyResponse response) {
        return repository.save(response);
    }

    public List<SurveyResponse> getAllResponses() {
        return repository.findAll();
    }
}
