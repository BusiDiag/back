package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "businesses")
public class Businesses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)  // Foreign key to Users table
    private Users owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private BusinessType type;

    @Column(name = "size")
    private String size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BusinessStatus status;

    @Column(name = "date")
    private LocalDate date;
}

