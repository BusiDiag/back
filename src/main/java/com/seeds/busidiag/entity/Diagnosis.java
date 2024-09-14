package com.seeds.busidiag.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false) // Foreign key to Businesses table
    private Businesses business;

    @PastOrPresent
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "score_cat1", nullable = false, columnDefinition = "float default 0")
    private float scoreCat1;

    @NotNull
    @Column(name = "score_cat2", nullable = false, columnDefinition = "float default 0")
    private float scoreCat2;

    @NotNull
    @Column(name = "score_cat3", nullable = false, columnDefinition = "float default 0")
    private float scoreCat3;

    @NotNull
    @Column(name = "score_cat4", nullable = false, columnDefinition = "float default 0")
    private float scoreCat4;

    @Lob
    @Column(name = "recommendations")
    private String recommendations;
}
