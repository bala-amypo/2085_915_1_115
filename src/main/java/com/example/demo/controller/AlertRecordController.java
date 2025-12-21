package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService alertService;

    public AlertRecordController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertRecord triggerAlert(@RequestBody AlertRecord alert) {
        return alertService.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertRecord acknowledge(@PathVariable Long id) {
        return alertService.acknowledgeAlert(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getByShipment(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public AlertRecord getById(@PathVariable Long id) {
        return alertService.getAllAlerts()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping
    public List<AlertRecord> getAll() {
        return alertService.getAllAlerts();
    }
}
