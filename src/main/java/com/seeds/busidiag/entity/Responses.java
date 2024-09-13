package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.QuestionCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @ManyToOne
    @JoinColumn(name = "diagnosis_id", nullable = false)  // Foreign key to Diagnosis table
    private Diagnosis diagnosis;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)  // Foreign key to Questions table
    private Questions question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionCategory category;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int importance;

    @Min(1)
    @Max(5)
    @Column(name = "user_score", nullable = false)
    private int userScore;

    @Column(name = "weighted_score", nullable = false)
    private float weightedScore;
}
