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
    public AlertRecord getAlertById(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with ID: " + id));
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = getAlertById(id); 
        alert.setAcknowledged(true);
        return alertRepository.save(alert);
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        List<AlertRecord> alerts = alertRepository.findByShipmentId(shipmentId);
        if (alerts.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No alerts found for shipment ID: " + shipmentId
            );
        }
        return alerts;
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
