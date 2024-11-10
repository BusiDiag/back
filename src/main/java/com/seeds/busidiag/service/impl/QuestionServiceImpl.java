package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Question;
import com.seeds.busidiag.repository.QuestionRepository;
import com.seeds.busidiag.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionsRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public int save(Question question) {
        Question savedQuestion = questionsRepository.save(question);
        return savedQuestion.getId();
    }

    @Override
    public Question findById(int id) {
        return questionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    @Override
    public int updateById(Question question, int id) {
        if (!questionsRepository.existsById(id)) {
            throw new RuntimeException("Question not found with id: " + id);
        }
        question.setId(id);
        questionsRepository.save(question);
        return id;
    }

    @Override
    public int deleteById(int id) {
        if (!questionsRepository.existsById(id)) {
            throw new RuntimeException("Question not found with id: " + id);
        }
        questionsRepository.deleteById(id);
        return id;
    }

    @Override
    public Question findByCategory(String category) {
        return questionsRepository.findByCategory(category)
                .orElseThrow(() -> new RuntimeException("No question found for category: " + category));
    }
}
