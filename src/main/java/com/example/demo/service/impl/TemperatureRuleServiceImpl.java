package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository ruleRepository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        validateRule(rule);
        return ruleRepository.save(rule);
    }

    @Override
    public TemperatureRule updateRule(Long id, TemperatureRule rule) {
        TemperatureRule existing = getRuleById(id);
        validateRule(rule);

        existing.setMinTemp(rule.getMinTemp());
        existing.setMaxTemp(rule.getMaxTemp());
        existing.setEffectiveFrom(rule.getEffectiveFrom());
        existing.setEffectiveTo(rule.getEffectiveTo());
        existing.setActive(rule.getActive());

        return ruleRepository.save(existing);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return ruleRepository.findApplicableRule(productType, date)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature rule not found"));
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return ruleRepository.findAll();
    }

    private void validateRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("Min temperature must be less than max temperature");
        }
    }

    private TemperatureRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature rule not found"));
    }
}
