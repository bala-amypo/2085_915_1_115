package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

@Service
public class BreachDetectionServiceImpl
        implements BreachDetectionService {

    private final BreachRecordRepository breachRecordRepository;

    public BreachDetectionServiceImpl(
            BreachRecordRepository breachRecordRepository) {
        this.breachRecordRepository = breachRecordRepository;
    }

    @Override
    public List<BreachRecord> getBreachesByShipmentId(Long shipmentId) {

        List<BreachRecord> breaches =
                breachRecordRepository.findByShipmentId(shipmentId);

        if (breaches == null || breaches.isEmpty()) {
            throw new ResourceNotFoundException(
                "No breach records found for shipmentId: " + shipmentId
            );
        }

        return breaches;
    }
}
