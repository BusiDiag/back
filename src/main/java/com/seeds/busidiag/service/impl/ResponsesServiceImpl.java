package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Responses;
import com.seeds.busidiag.enums.QuestionCategory;
import com.seeds.busidiag.repository.ResponsesRepository;
import com.seeds.busidiag.service.ResponsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsesServiceImpl implements ResponsesService {

    private final ResponsesRepository responsesRepository;

    @Autowired
    public ResponsesServiceImpl(ResponsesRepository responsesRepository) {
        this.responsesRepository = responsesRepository;
    }

    @Override
    public int save(Responses response) {
        Responses savedResponse = responsesRepository.save(response);
        return savedResponse.getId();
    }

    @Override
    public Responses findById(int id) {
        return responsesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response not found with id: " + id));
    }

    @Override
    public int updateById(Responses response, int id) {
        if (!responsesRepository.existsById(id)) {
            throw new RuntimeException("Response not found with id: " + id);
        }
        response.setId(id);
        responsesRepository.save(response);
        return id;
    }

    @Override
    public int deleteById(int id) {
        if (!responsesRepository.existsById(id)) {
            throw new RuntimeException("Response not found with id: " + id);
        }
        responsesRepository.deleteById(id);
        return id;
    }

    @Override
    public Responses findByDiagnosisId(int diagnosisId) {
        return responsesRepository.findByDiagnosisId(diagnosisId)
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId));
    }

    @Override
    public Responses findByQuestionId(int questionId) {
        return responsesRepository.findByQuestionId(questionId)
                .orElseThrow(() -> new RuntimeException("No response found for question ID: " + questionId));
    }

    @Override
    public Responses findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId) {
        return responsesRepository.findByDiagnosisIdAndQuestionId(diagnosisId, questionId)
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId + " and question ID: " + questionId));
    }

    @Override
    public Responses findByDiagnosisIdAndQuestionIdAndCategory(int diagnosisId, int questionId, String category) {
        return responsesRepository.findByDiagnosisIdAndQuestionIdAndCategory(diagnosisId, questionId, QuestionCategory.valueOf(category))
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId + ", question ID: " + questionId + " and category: " + category));
    }
}
