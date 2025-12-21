package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records")
public class BreachRecordController {

    private final BreachDetectionService breachService;

    public BreachRecordController(BreachDetectionService breachService) {
        this.breachService = breachService;
    }

    @PostMapping
    public BreachRecord logBreach(@RequestBody BreachRecord breach) {
        return breachService.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(@PathVariable Long id) {
        return breachService.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getByShipment(@PathVariable Long shipmentId) {
        return breachService.getBreachesByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public BreachRecord getById(@PathVariable Long id) {
        return breachService.getBreachById(id);
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return breachService.getAllBreaches();
    }
}
