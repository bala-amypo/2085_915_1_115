package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AlertService;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.entity.AlertRecord;

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
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return alertRepository.findByShipmentId(shipmentId);
    }
}
