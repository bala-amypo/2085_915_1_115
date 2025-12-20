package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/temperature-rules")
public class TemperatureRuleController {

    private final TemperatureRuleService ruleService;

    public TemperatureRuleController(
            TemperatureRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public TemperatureRule createRule(
            @RequestBody TemperatureRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @GetMapping("/{id}")
    public TemperatureRule getRuleById(
            @PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(
            @PathVariable Long id) {
        ruleService.deleteRule(id);
    }
}
