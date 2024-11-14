package com.seeds.busidiag.controller;

import com.seeds.busidiag.entity.Response;
import com.seeds.busidiag.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<Integer> createResponse(@RequestBody Response response) {
        try {
            int id = responseService.save(response);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable int id) {
        try {
            Response response = responseService.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diagnosis/id={id}")
    public ResponseEntity<Response> getResponseByDiagnosisId(@PathVariable int id) {
        try {
            Response response = responseService.findByDiagnosisId(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diagnosis/id={diagnosisId}/question/id={questionId}")
    public ResponseEntity<Response> getResponseByDiagnosisIdAndQuestionId(@PathVariable int diagnosisId, @PathVariable int questionId) {
        try {
            Response response = responseService.findByDiagnosisIdAndQuestionId(diagnosisId, questionId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diagnosis/id={diagnosisId}/question/id={questionId}/category/id={categoryId}")
    public ResponseEntity<Response> getResponseByDiagnosisIdAndQuestionIdAndCategoryId(@PathVariable int diagnosisId, @PathVariable int questionId, @PathVariable String categoryId) {
        try {
            Response response = responseService.findByDiagnosisIdAndQuestionIdAndCategory(diagnosisId, questionId, categoryId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateResponse(@RequestBody Response question, @PathVariable int id) {
        try {
            int updatedId = responseService.updateById(question, id);
            return new ResponseEntity<>(updatedId, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteResponse(@PathVariable int id) {
        try {
            int deletedId = responseService.deleteById(id);
            return new ResponseEntity<>(deletedId, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}