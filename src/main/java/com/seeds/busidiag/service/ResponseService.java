package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Response;

public interface ResponseService {
    int save(Response response);

    Response findById(int id);

    int updateById(Response response, int id);
    int deleteById(int id);

    Response findByDiagnosisId(int diagnosisId);

    Response findByQuestionId(int questionId);

    Response findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId);

    Response findByDiagnosisIdAndQuestionIdAndCategory(int diagnosisId, int questionId, String category);
}
