package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    Optional<Diagnosis> findByBusinessId(int businessId);
}
