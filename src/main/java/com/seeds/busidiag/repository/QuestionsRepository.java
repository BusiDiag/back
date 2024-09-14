package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

    Optional<Questions> findByCategory(String category);
}
