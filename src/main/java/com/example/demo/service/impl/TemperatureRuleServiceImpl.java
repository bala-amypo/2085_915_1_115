package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

@Service
public class TemperatureRuleServiceImpl
        implements TemperatureRuleService {

    private final TemperatureRuleRepository ruleRepository;

    public TemperatureRuleServiceImpl(
            TemperatureRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public TemperatureRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public void deleteRule(Long id) {
        TemperatureRule rule = getRuleById(id);
        ruleRepository.delete(rule);
    }
}
