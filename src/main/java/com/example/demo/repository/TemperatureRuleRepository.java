package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    @Query("""
        SELECT r FROM TemperatureRule r
        WHERE r.productType = :productType
          AND r.active = true
          AND :date BETWEEN r.effectiveFrom AND r.effectiveTo
    """)
    Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date);
}
