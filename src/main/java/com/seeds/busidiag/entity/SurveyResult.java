package com.seeds.busidiag.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Builder
@Getter
public class SurveyResult {

    private final Long resultPrimaryKey;
    private final Long buisPrimaryKey;
    private final ArrayList<Integer> sectors;
    private final int score;
}
