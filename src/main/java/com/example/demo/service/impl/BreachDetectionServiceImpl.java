package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.BreachDetectionService;

@Service
public class BreachDetectionServiceImpl
        implements BreachDetectionService {

    private final BreachRecordRepository breachRepository;
    private final ShipmentRecordRepository shipmentRepository;

    public BreachDetectionServiceImpl(
            BreachRecordRepository breachRepository,
            ShipmentRecordRepository shipmentRepository) {
        this.breachRepository = breachRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return breachRepository.save(breach);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Breach not found"));

        breach.setResolved(true);
        return breachRepository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {

        ShipmentRecord shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        if (shipment.getBreaches() == null ||
            shipment.getBreaches().isEmpty()) {
            throw new ResourceNotFoundException(
                    "No breaches found for shipment");
        }

        return shipment.getBreaches();
    }
}
