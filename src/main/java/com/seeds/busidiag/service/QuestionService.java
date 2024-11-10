package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Question;

public interface QuestionService {
    int save(Question question);

    Question findById(int id);

    int updateById(Question question, int id);
    int deleteById(int id);

    Question findByCategory(String category);
}
