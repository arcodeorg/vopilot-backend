package com.arcode.vopilot.assessment.domain.models.aggregates;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name="description", length = 500, nullable = false)
    private String description;

    @Column(name = "number_of_questions", nullable = false)
    private Integer numberOfQuestions;

    public Evaluation(String title, String description, Integer numberOfQuestions) {
        if (title == null || title.isEmpty()) {
            throw new ValidationException("Title cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new ValidationException("Description cannot be null or empty");
        }
        if (numberOfQuestions == null || numberOfQuestions <= 0) {
            throw new ValidationException("Number of questions cannot be null or less than 1");
        }
        this.title = title;
        this.description = description;
        this.numberOfQuestions = numberOfQuestions;
    }
}
