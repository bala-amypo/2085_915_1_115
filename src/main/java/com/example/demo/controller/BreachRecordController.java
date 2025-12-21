package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breaches")
public class BreachRecordController {

    private final BreachDetectionService breachDetectionService;

    public BreachRecordController(BreachDetectionService breachDetectionService) {
        this.breachDetectionService = breachDetectionService;
    }

    @PostMapping
    public BreachRecord logBreach(@RequestBody BreachRecord breach) {
        return breachDetectionService.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(@PathVariable Long id) {
        return breachDetectionService.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipment(@PathVariable Long shipmentId) {
        return breachDetectionService.getBreachesByShipment(shipmentId);
    }
}
