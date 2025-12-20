package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertRecordController {

    private final AlertService alertService;

    public AlertRecordController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertRecord triggerAlert(@RequestBody AlertRecord alert) {
        return alertService.triggerAlert(alert);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getAlertsByShipment(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipment(shipmentId);
    }
}
