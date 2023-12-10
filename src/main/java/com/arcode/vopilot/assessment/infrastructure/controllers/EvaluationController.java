package com.arcode.vopilot.assessment.infrastructure.controllers;

import com.arcode.vopilot.assessment.domain.models.aggregates.Evaluation;
import com.arcode.vopilot.assessment.domain.services.EvaluationService;
import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;
import com.arcode.vopilot.assessment.infrastructure.resources.response.EvaluationResponse;
import com.arcode.vopilot.shared.domain.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/evaluations", produces = "application/json")
@Tag(name = "Evaluations", description = "The Evaluations API")
public class EvaluationController {
    private final EvaluationService evaluationService;
    private final ModelMapper modelMapper;

    public EvaluationController(EvaluationService evaluationService, ModelMapper modelMapper) {
        this.evaluationService = evaluationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<EvaluationResponse> createEvaluation(@RequestBody EvaluationRequest evaluationRequest) {
        Long evaluationId = evaluationService.create(evaluationRequest);
        if (evaluationId == null) {
            throw new ValidationException("Evaluation not created");
        }
        Optional<Evaluation> evaluation = evaluationService.get(evaluationId);
        if (evaluation.isEmpty()) {
            throw new ResourceNotFoundException("Evaluation with id " + evaluationId + " not found");
        }
        EvaluationResponse evaluationResponse = modelMapper.map(evaluation, EvaluationResponse.class);
        return new ResponseEntity<>(evaluationResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EvaluationResponse>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAll();
        List<EvaluationResponse> evaluationResponses = evaluations.stream()
                .map(evaluation -> modelMapper.map(evaluation, EvaluationResponse.class))
                .toList();
        return new ResponseEntity<>(evaluationResponses, HttpStatus.OK);
    }

    @GetMapping("/{evaluationId}")
    public ResponseEntity<EvaluationResponse> getEvaluation(@PathVariable Long evaluationId) {
        Optional<Evaluation> evaluation = evaluationService.get(evaluationId);
        if (evaluation.isEmpty()) {
            throw new ResourceNotFoundException("Evaluation with id " + evaluationId + " not found");
        }
        EvaluationResponse evaluationResponse = modelMapper.map(evaluation, EvaluationResponse.class);
        return new ResponseEntity<>(evaluationResponse, HttpStatus.OK);
    }
}










