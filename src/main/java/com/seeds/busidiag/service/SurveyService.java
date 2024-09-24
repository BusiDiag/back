package com.seeds.busidiag.service;

import com.seeds.busidiag.dto.UpdateSurveyResultDto;
import com.seeds.busidiag.entity.SurveyResult;

import java.util.ArrayList;

public interface SurveyService {

    int save(SurveyResult surveyResult);

    ArrayList<SurveyResult> findAll(Long page, Long offset);

    SurveyResult findById(Long id);

    int updateById(UpdateSurveyResultDto updateSurveyResultDto, Long id);

    int deleteById(Long id);
}
