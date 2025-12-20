package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository alertRepository;

    public AlertServiceImpl(AlertRecordRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public AlertRecord createAlert(AlertRecord alert) {
        return alertRepository.save(alert);
    }

    @Override
    public AlertRecord getAlertById(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alert not found"));
    }
}
