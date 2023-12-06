package com.example.schoolProject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String pesel;
    private List<Double> scores;

    public StudentEntity() {
        scores = new ArrayList<>();
    }

    public void addScore(double score) {
        if (score > 5.0 || score < 2.0)
            throw new IllegalArgumentException("Invalid score value");
        scores.add(score);
    }
}
