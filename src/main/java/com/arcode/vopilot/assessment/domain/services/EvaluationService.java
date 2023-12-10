package com.arcode.vopilot.assessment.domain.services;

import com.arcode.vopilot.assessment.domain.models.aggregates.Evaluation;
import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {
    Long create(EvaluationRequest evaluationRequest);
    Optional<Evaluation> get(Long evaluationId);
    List<Evaluation> getAll();
}
