package com.arcode.vopilot.assessment.application.usecases;

import com.arcode.vopilot.assessment.domain.models.aggregates.Evaluation;
import com.arcode.vopilot.assessment.domain.services.EvaluationService;
import com.arcode.vopilot.assessment.infrastructure.repositories.EvaluationRepository;
import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationUseCase implements EvaluationService {
    private final EvaluationRepository evaluationRepository;
    public EvaluationUseCase(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }
    @Override
    public Long create(EvaluationRequest evaluationRequest) {
        var evaluationTest = new Evaluation(evaluationRequest.getTitle(), evaluationRequest.getDescription(), evaluationRequest.getNumberOfQuestions());
        evaluationRepository.save(evaluationTest);
        return evaluationTest.getId();
    }

    @Override
    public List<Evaluation> getAll() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> get(Long evaluationId) {
        return evaluationRepository.findById(evaluationId);
    }
}
