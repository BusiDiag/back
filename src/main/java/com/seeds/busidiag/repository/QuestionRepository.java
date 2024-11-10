package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Optional<Question> findByCategory(String category);
}
