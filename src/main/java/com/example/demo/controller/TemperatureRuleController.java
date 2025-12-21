package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRuleController {

    private final TemperatureRuleService ruleService;

    public TemperatureRuleController(TemperatureRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public TemperatureRule updateRule(@PathVariable Long id,
                                      @RequestBody TemperatureRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRule getRuleForProduct(
            @PathVariable String productType,
            @RequestParam(required = false) LocalDate date) {

        return ruleService.getRuleForProduct(
                productType,
                date != null ? date : LocalDate.now()
        );
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
