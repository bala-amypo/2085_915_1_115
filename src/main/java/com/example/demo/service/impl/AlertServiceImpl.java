package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

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
        return alertRepository.findByShipment_Id(shipmentId);
    }
}
