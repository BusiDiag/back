package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.dto.UpdateSurveyResultDto;
import com.seeds.busidiag.entity.SurveyResult;
import com.seeds.busidiag.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResultServiceImpl implements ResultService {

    public ResultServiceImpl() {
    }

    @Override
    public int save(SurveyResult surveyResult) {
        return 0;
    }

    @Override
    public ArrayList<SurveyResult> findAll(Long page, Long offset) {
        return null;
    }

    @Override
    public SurveyResult findById(Long id) {
        return null;
    }

    @Override
    public int updateById(UpdateSurveyResultDto updateSurveyResultDto, Long id) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }
}
