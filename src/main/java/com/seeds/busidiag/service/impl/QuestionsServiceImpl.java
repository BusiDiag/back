package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Questions;
import com.seeds.busidiag.repository.QuestionsRepository;
import com.seeds.busidiag.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepository questionsRepository;

    @Autowired
    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public int save(Questions question) {
        Questions savedQuestion = questionsRepository.save(question);
        return savedQuestion.getId();
    }

    @Override
    public Questions findById(int id) {
        return questionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    @Override
    public int updateById(Questions question, int id) {
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
    public Questions findByCategory(String category) {
        return questionsRepository.findByCategory(category)
                .orElseThrow(() -> new RuntimeException("No question found for category: " + category));
    }
}
