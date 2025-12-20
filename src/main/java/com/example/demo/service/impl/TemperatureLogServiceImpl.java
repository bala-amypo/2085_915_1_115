package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;

@Service
public class TemperatureLogServiceImpl
        implements TemperatureLogService {

    private final TemperatureSensorLogRepository logRepository;
    private final ShipmentRecordRepository shipmentRepository;

    public TemperatureLogServiceImpl(
            TemperatureSensorLogRepository logRepository,
            ShipmentRecordRepository shipmentRepository) {
        this.logRepository = logRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public TemperatureSensorLog addLog(
            Long shipmentId, TemperatureSensorLog log) {

        ShipmentRecord shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        // relationship handling
        log.setShipment(shipment);
        log.setRecordedAt(LocalDateTime.now());

        return logRepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return logRepository.findByShipment_Id(shipmentId);
    }
}
