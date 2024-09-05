package com.seeds.busidiag.dto;

import com.seeds.busidiag.entity.SurveyResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSurveyResultDto {

    private Long resultPrimaryKey;
    private Long buisPrimaryKey;
    private ArrayList<Integer> sectors;
    private int score;

    public SurveyResult toEntity() {
        return SurveyResult.builder()
                .resultPrimaryKey(resultPrimaryKey)
                .buisPrimaryKey(buisPrimaryKey)
                .sectors(sectors)
                .score(score)
                .build();
    }
}
