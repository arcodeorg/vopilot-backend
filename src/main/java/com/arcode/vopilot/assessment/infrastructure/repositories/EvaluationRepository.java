package com.arcode.vopilot.assessment.infrastructure.repositories;

import com.arcode.vopilot.assessment.domain.models.aggregates.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
