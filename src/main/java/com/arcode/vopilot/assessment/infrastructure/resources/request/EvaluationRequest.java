package com.arcode.vopilot.assessment.infrastructure.resources.request;

import lombok.Getter;

@Getter
public class EvaluationRequest {
    private String title;
    private String description;
    private Integer numberOfQuestions;
}
