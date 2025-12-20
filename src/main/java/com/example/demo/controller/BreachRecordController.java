package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;

@RestController
@RequestMapping("/breaches")
public class BreachRecordController {

    private final BreachDetectionService breachService;

    public BreachRecordController(
            BreachDetectionService breachService) {
        this.breachService = breachService;
    }

    @PostMapping
    public BreachRecord logBreach(
            @RequestBody BreachRecord breach) {
        return breachService.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(
            @PathVariable Long id) {
        return breachService.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipment(
            @PathVariable Long shipmentId) {
        return breachService.getBreachesByShipment(shipmentId);
    }
}
