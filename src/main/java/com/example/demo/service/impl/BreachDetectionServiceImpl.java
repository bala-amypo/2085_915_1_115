package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRepository;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRepository) {
        this.breachRepository = breachRepository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return breachRepository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        List<BreachRecord> breaches = breachRepository.findByShipmentId(shipmentId);
        if (breaches.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No breaches found for shipment ID: " + shipmentId
            );
        }
        return breaches;
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        List<BreachRecord> breaches = breachRepository.findAll();
        if (breaches.isEmpty()) {
            throw new ResourceNotFoundException("No breach records found");
        }
        return breaches;
    }


    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = getBreachById(id);
        breach.setResolved(true);
        return breachRepository.save(breach);
    }

    @Override
    public BreachRecord getBreachById(Long id) {
        return breachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
    }
}
