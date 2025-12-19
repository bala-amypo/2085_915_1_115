package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.ShipmentRecordService;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository shipmentRepository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(Long id, String newStatus) {
        ShipmentRecord shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        shipment.setStatus(newStatus);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return shipmentRepository.findByShipmentCode(shipmentCode);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRepository.findAll();
    }
}
