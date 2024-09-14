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
@Table(name = "responses")
public class Responses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "diagnosis_id", nullable = false)  // Foreign key to Diagnosis table
    private Diagnosis diagnosis;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)  // Foreign key to Questions table
    private Questions question;

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
    @Min(1)
    @Max(5)
    @Column(name = "user_score", nullable = false)
    private int userScore;

    @NotNull
    @Column(name = "weighted_score", nullable = false)
    private float weightedScore;
}
