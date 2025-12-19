package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService temperatureLogService;

    public TemperatureLogController(TemperatureLogService temperatureLogService) {
        this.temperatureLogService = temperatureLogService;
    }

    @PostMapping
    public TemperatureSensorLog recordTemperature(@RequestBody TemperatureSensorLog log) {
        return temperatureLogService.recordLog(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipment(@PathVariable Long shipmentId) {
        return temperatureLogService.getLogsByShipment(shipmentId);
    }
}
