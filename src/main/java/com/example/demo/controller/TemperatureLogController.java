package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;

@RestController
@RequestMapping("/temperature-logs")
public class TemperatureLogController {

    private final TemperatureLogService temperatureLogService;

    public TemperatureLogController(
            TemperatureLogService temperatureLogService) {
        this.temperatureLogService = temperatureLogService;
    }

    @PostMapping("/shipment/{shipmentId}")
    public TemperatureSensorLog addTemperatureLog(
            @PathVariable Long shipmentId,
            @RequestBody TemperatureSensorLog log) {

        return temperatureLogService.addLog(shipmentId, log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipment(
            @PathVariable Long shipmentId) {

        return temperatureLogService.getLogsByShipment(shipmentId);
    }
}
