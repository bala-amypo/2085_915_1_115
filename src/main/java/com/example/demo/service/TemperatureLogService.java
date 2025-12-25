package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLog;

import java.util.List;
import java.util.Optional;

public interface TemperatureLogService {

    TemperatureSensorLog recordLog(TemperatureSensorLog log);

    List<TemperatureSensorLog> getLogsByShipment(Long shipmentId);

    Optional<TemperatureSensorLog> getLogById(Long id);

    List<TemperatureSensorLog> getAllLogs();
}
