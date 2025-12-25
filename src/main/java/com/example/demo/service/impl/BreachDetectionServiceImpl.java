package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
        breach.setResolved(true);
        return breachRepository.save(breach);
    }

    @Override
    public Optional<BreachRecord> getBreachById(Long id) {
        return breachRepository.findById(id);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepository.findByShipmentId(shipmentId);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return breachRepository.findAll();
    }
}
