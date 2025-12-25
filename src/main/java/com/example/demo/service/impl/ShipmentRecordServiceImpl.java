package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;

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
    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return shipmentRepository.findByShipmentCode(shipmentCode);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRepository.findAll();
    }
}
