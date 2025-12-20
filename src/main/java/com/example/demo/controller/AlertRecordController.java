package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/alerts")
public class AlertRecordController {

    private final AlertService alertService;

    public AlertRecordController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertRecord createAlert(@RequestBody AlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getAlertsByShipment(
            @PathVariable Long shipmentId) {
        return alertService.getAlertsByShipment(shipmentId);
    }
}
