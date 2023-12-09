package com.arcode.vopilot.assessment.infrastructure.resources.response;

import lombok.Getter;

@Getter
public class EvaluationResponse {
    private Long id;
    private String title;
    private String description;
    private Integer numberOfQuestions;
}
