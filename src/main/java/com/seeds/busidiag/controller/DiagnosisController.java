package com.seeds.busidiag.controller;

import com.seeds.busidiag.entity.Diagnosis;
import com.seeds.busidiag.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @PostMapping
    public ResponseEntity<Integer> createDiagnosis(@RequestBody Diagnosis diagnosis) {
        try {
            int id = diagnosisService.save(diagnosis);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable int id) {
        return diagnosisService.findById(id)
                .map(diagnosis -> new ResponseEntity<>(diagnosis, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/business/{businessId}")
    public ResponseEntity<Diagnosis> getDiagnosisByBusinessId(@PathVariable int businessId) {
        return diagnosisService.findByBusinessId(businessId)
                .map(diagnosis -> new ResponseEntity<>(diagnosis, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateDiagnosis(@RequestBody Diagnosis diagnosis, @PathVariable int id) {
        try {
            int updatedId = diagnosisService.updateById(diagnosis, id);
            return new ResponseEntity<>(updatedId, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteDiagnosis(@PathVariable int id) {
        try {
            int deletedId = diagnosisService.deleteById(id);
            return new ResponseEntity<>(deletedId, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}