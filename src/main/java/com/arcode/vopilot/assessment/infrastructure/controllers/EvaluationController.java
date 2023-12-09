package com.arcode.vopilot.assessment.infrastructure.controllers;

import com.arcode.vopilot.assessment.application.usecases.EvaluationUseCase;
import com.arcode.vopilot.assessment.domain.services.EvaluationService;
import com.arcode.vopilot.assessment.infrastructure.resources.request.EvaluationRequest;
import com.arcode.vopilot.assessment.infrastructure.resources.response.EvaluationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        EvaluationResponse createEvaluation = modelMapper.map(evaluationRequest, EvaluationResponse.class);
        Long id = evaluationService.handle(evaluationRequest); //CONTROLLER CALLS USE-CASE
        return new ResponseEntity<>(createEvaluation, HttpStatus.CREATED);
    }
}










