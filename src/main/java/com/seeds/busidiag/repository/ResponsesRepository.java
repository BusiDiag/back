package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Responses;
import com.seeds.busidiag.enums.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsesRepository extends JpaRepository<Responses, Integer> {

    Optional<Responses> findByDiagnosisId(int diagnosisId);

    Optional<Responses> findByQuestionId(int questionId);

    Optional<Responses> findByDiagnosisIdAndQuestionId(int diagnosisId, int questionId);

    Optional<Responses> findByDiagnosisIdAndQuestionIdAndCategory(int diagnosis_id, int question_id, QuestionCategory category);
}
