package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Response;
import com.seeds.busidiag.enums.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    Optional<Response> findByDiagnosisId(int diagnosisId);

    Optional<Response> findByQuestionId(int questionId);

    Optional<Response> findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId);

    Optional<Response> findByDiagnosisIdAndQuestionIdAndCategory(int diagnosis_id, int question_id, QuestionCategory category);
}
