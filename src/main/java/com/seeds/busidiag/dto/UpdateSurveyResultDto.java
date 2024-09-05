package com.seeds.busidiag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSurveyResultDto {

    private Long resultPrimaryKey;
    private Long buisPrimaryKey;
    private ArrayList<Integer> sectors;
    private int score;
}
