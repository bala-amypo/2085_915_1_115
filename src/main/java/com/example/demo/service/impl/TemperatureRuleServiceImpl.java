package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository ruleRepository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }
        return ruleRepository.save(rule);
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String productType, LocalDate date) {
        return ruleRepository.findApplicableRule(productType, date);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }
}
