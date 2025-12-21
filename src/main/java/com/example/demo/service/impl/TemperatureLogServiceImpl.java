package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository logRepository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        List<TemperatureSensorLog> logs = logRepository.findByShipmentId(shipmentId);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No temperature logs found for shipment ID: " + shipmentId);
        }
        return logs;
    }

    @Override
    public TemperatureSensorLog getLogById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature log not found with ID: " + id));
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        List<TemperatureSensorLog> logs = logRepository.findAll();
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No temperature logs found");
        }
        return logs;
    }

}
