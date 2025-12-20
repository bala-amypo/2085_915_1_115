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

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipmentId(
            @PathVariable Long shipmentId) {

        return breachDetectionService
                .getBreachesByShipmentId(shipmentId);
    }
}
