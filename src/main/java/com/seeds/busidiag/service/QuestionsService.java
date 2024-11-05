package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Questions;

public interface QuestionsService {
    int save(Questions question);
    Questions findById(int id);
    int updateById(Questions question, int id);
    int deleteById(int id);
    Questions findByCategory(String category);
}
