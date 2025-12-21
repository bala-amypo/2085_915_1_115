package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService temperatureRuleService;

    public TemperatureRuleController(TemperatureRuleService temperatureRuleService) {
        this.temperatureRuleService = temperatureRuleService;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return temperatureRuleService.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return temperatureRuleService.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public Optional<TemperatureRule> getRuleForProduct(
            @PathVariable String productType,
            @RequestParam LocalDate date) {
        return temperatureRuleService.getRuleForProduct(productType, date);
    }
}
