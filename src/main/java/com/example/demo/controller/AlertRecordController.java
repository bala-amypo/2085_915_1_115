package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertRecordService;

@RestController
@RequestMapping("/alerts")
public class AlertRecordController {

    private final AlertRecordService alertService;

    public AlertRecordController(
            AlertRecordService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertRecord createAlert(
            @RequestBody AlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping("/{id}")
    public AlertRecord getAlertById(
            @PathVariable Long id) {
        return alertService.getAlertById(id);
    }
}
