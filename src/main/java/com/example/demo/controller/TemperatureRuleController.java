package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService ruleService;

    public TemperatureRuleController(TemperatureRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public Optional<TemperatureRule> getRuleForProduct(
            @PathVariable String productType,
            @RequestParam LocalDate date) {
        return ruleService.getRuleForProduct(productType, date);
    }
}
