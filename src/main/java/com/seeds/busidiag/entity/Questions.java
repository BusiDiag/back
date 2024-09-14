package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.QuestionCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionCategory category;

    @NotNull
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int importance;

    @NotNull
    @Column(name = "question_text", nullable = false)
    private String questionText;
}
