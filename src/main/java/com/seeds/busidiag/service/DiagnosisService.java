package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Diagnosis;
import java.util.Optional;

public interface DiagnosisService {

    int save(Diagnosis diagnosis);
    Optional<Diagnosis> findById(int id);

    Optional<Diagnosis> findByBusinessId(int businessId);

    int updateById(Diagnosis diagnosis, int id);

    int deleteById(int id);

}
