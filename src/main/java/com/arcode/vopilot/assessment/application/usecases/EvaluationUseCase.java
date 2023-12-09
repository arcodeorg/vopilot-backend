package com.arcode.vopilot.assessment.application.usecases;

import com.arcode.vopilot.assessment.domain.models.aggregates.Evaluation;
import com.arcode.vopilot.assessment.domain.services.EvaluationService;
import com.arcode.vopilot.assessment.infrastructure.repositories.EvaluationRepository;
import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;
import org.springframework.stereotype.Service;

@Service
public class EvaluationUseCase implements EvaluationService {
    private final EvaluationRepository evaluationRepository;
    public EvaluationUseCase(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }
    @Override
    public Long handle(EvaluationRequest evaluationRequest) {
        var evaluationTest = new Evaluation(evaluationRequest.getTitle(), evaluationRequest.getDescription(), evaluationRequest.getNumberOfQuestions());
        evaluationRepository.save(evaluationTest);
        return evaluationTest.getId();
    }
}
