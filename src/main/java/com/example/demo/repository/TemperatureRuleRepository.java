package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TemperatureRule;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();
    default Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date) {
        return findByActiveTrue().stream()
            .filter(rule -> rule.getProductType().equals(productType))
            .filter(rule ->!date.isBefore(rule.getEffectiveFrom()) &&!date.isAfter(rule.getEffectiveTo()))
            .findFirst();
    }
}
