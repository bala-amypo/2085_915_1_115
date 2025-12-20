package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.entity.BreachRecord;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRepo;
    private final ShipmentRecordRepository shipmentRepo;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRepo, ShipmentRecordRepository shipmentRepo) {
        this.breachRepo = breachRepo;
        this.shipmentRepo = shipmentRepo;
    }

    public BreachRecord logBreach(BreachRecord breach) {
        return breachRepo.save(breach);
    }

    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
        breach.setResolved(true);
        return breachRepo.save(breach);
    }

    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        ShipmentRecord shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        if (shipment.getBreaches().isEmpty()) {
            throw new ResourceNotFoundException("No breaches found for shipment");
        }
        return shipment.getBreaches();
    }
}
