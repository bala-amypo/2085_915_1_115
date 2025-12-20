package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.entity.TemperatureSensorLog;

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
        return logRepository.findByShipmentId(shipmentId);
    }
}
