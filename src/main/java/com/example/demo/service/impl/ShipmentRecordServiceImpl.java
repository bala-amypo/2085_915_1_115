package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;

@Service
public class ShipmentRecordServiceImpl
        implements ShipmentRecordService {

    private final ShipmentRecordRepository shipmentRepository;

    public ShipmentRecordServiceImpl(
            ShipmentRecordRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public ShipmentRecord getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public ShipmentRecord updateShipment(Long id, ShipmentRecord shipment) {
        ShipmentRecord existing = getShipmentById(id);

        existing.setShipmentCode(shipment.getShipmentCode());
        existing.setOrigin(shipment.getOrigin());
        existing.setDestination(shipment.getDestination());
        existing.setStatus(shipment.getStatus());

        return shipmentRepository.save(existing);
    }

    @Override
    public void deleteShipment(Long id) {
        ShipmentRecord shipment = getShipmentById(id);
        shipmentRepository.delete(shipment);
    }
}
