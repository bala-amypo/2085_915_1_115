package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return logRepository.findByShipmentId(shipmentId);
    }

    @Override
    public Optional<TemperatureSensorLog> getLogById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return logRepository.findAll();
    }
}
