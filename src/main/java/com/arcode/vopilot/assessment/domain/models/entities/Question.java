package com.arcode.vopilot.assessment.domain.models.entities;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    public Question(String title) {
        if (title == null || title.isEmpty()) {
            throw new ValidationException("Title cannot be null or empty");
        }
        this.title = title;
    }
}
