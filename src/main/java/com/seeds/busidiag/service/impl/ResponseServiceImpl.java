package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Response;
import com.seeds.busidiag.enums.QuestionCategory;
import com.seeds.busidiag.repository.ResponseRepository;
import com.seeds.busidiag.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responsesRepository;

    @Autowired
    public ResponseServiceImpl(ResponseRepository responsesRepository) {
        this.responsesRepository = responsesRepository;
    }

    @Override
    public int save(Response response) {
        Response savedResponse = responsesRepository.save(response);
        return savedResponse.getId();
    }

    @Override
    public Response findById(int id) {
        return responsesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response not found with id: " + id));
    }

    @Override
    public int updateById(Response response, int id) {
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
    public Response findByDiagnosisId(int diagnosisId) {
        return responsesRepository.findByDiagnosisId(diagnosisId)
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId));
    }

    @Override
    public Response findByQuestionId(int questionId) {
        return responsesRepository.findByQuestionId(questionId)
                .orElseThrow(() -> new RuntimeException("No response found for question ID: " + questionId));
    }

    @Override
    public Response findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId) {
        return responsesRepository.findByDiagnosisIdAndQuestionId(diagnosisId, questionId)
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId + " and question ID: " + questionId));
    }

    @Override
    public Response findByDiagnosisIdAndQuestionIdAndCategory(int diagnosisId, int questionId, String category) {
        return responsesRepository.findByDiagnosisIdAndQuestionIdAndCategory(diagnosisId, questionId, QuestionCategory.valueOf(category))
                .orElseThrow(() -> new RuntimeException("No response found for diagnosis ID: " + diagnosisId + ", question ID: " + questionId + " and category: " + category));
    }
}
