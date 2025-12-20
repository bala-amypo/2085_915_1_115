package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;

@RestController
@RequestMapping("/breaches")
public class BreachRecordController {

    private final BreachDetectionService breachDetectionService;

    public BreachRecordController(
            BreachDetectionService breachDetectionService) {
        this.breachDetectionService = breachDetectionService;
    }

    /**
     * POST /breaches
     * Logs a new breach record
     */
    @PostMapping
    public BreachRecord logBreach(
            @RequestBody BreachRecord breachRecord) {

        return breachDetectionService.logBreach(breachRecord);
    }

    /**
     * PUT /breaches/{id}/resolve
     * Marks a breach as resolved
     */
    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(
            @PathVariable Long id) {

        return breachDetectionService.resolveBreach(id);
    }

    /**
     * GET /breaches/shipment/{shipmentId}
     * Fetches all breaches for a shipment
     */
    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipment(
            @PathVariable Long shipmentId) {

        return breachDetectionService
                .getBreachesByShipment(shipmentId);
    }
}
