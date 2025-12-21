package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository alertRepository;

    public AlertServiceImpl(AlertRecordRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public AlertRecord triggerAlert(AlertRecord alert) {
        return alertRepository.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
        alert.setAcknowledged(true);
        return alertRepository.save(alert);
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return alertRepository.findByShipmentId(shipmentId);
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        List<AlertRecord> alerts = alertRepository.findAll();

        if (alerts.isEmpty()) {
            throw new ResourceNotFoundException("No alerts found");
        }

        return alerts;
    }

}
