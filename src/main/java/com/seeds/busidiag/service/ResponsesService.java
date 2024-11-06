package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Responses;

public interface ResponsesService {
    int save(Responses response);
    Responses findById(int id);
    int updateById(Responses response, int id);
    int deleteById(int id);
    Responses findByDiagnosisId(int diagnosisId);
    Responses findByQuestionId(int questionId);
    Responses findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId);
    Responses findByDiagnosisIdAndQuestionIdAndCategory(int diagnosisId, int questionId, String category);
}
