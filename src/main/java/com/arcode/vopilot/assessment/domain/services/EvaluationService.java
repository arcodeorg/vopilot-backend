package com.arcode.vopilot.assessment.domain.services;

import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;

public interface EvaluationService {
    Long handle(EvaluationRequest evaluationRequest);
}
