package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Diagnosis;
import com.seeds.busidiag.repository.DiagnosisRepository;
import com.seeds.busidiag.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public int save(Diagnosis diagnosis) {
        Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
        return savedDiagnosis.getId();
    }

    @Override
    public Optional<Diagnosis> findById(int id) {
        return diagnosisRepository.findById(id);
    }

    @Override
    public Optional<Diagnosis> findByBusinessId(int businessId) {
        return diagnosisRepository.findByBusinessId(businessId);
    }

    @Override
    public int updateById(Diagnosis diagnosis, int id) {
        if (!diagnosisRepository.existsById(id)) {
            throw new RuntimeException("Diagnosis not found with id: " + id);
        }
        diagnosis.setId(id);
        diagnosisRepository.save(diagnosis);
        return id;
    }

    @Override
    public int deleteById(int id) {
        if (!diagnosisRepository.existsById(id)) {
            throw new RuntimeException("Diagnosis not found with id: " + id);
        }
        diagnosisRepository.deleteById(id);
        return id;
    }
}
