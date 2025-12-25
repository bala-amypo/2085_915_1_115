package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService logService;

    public TemperatureLogController(TemperatureLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public TemperatureSensorLog recordLog(@RequestBody TemperatureSensorLog log) {
        return logService.recordLog(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipment(@PathVariable Long shipmentId) {
        return logService.getLogsByShipment(shipmentId);
    }
}
