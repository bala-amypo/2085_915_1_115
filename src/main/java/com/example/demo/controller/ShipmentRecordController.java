package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService shipmentService;

    public ShipmentRecordController(ShipmentRecordService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ShipmentRecord createShipment(
            @RequestBody ShipmentRecord shipment) {
        return shipmentService.createShipment(shipment);
    }

    @GetMapping("/{id}")
    public ShipmentRecord getShipmentById(
            @PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PutMapping("/{id}")
    public ShipmentRecord updateShipment(
            @PathVariable Long id,
            @RequestBody ShipmentRecord shipment) {
        return shipmentService.updateShipment(id, shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(
            @PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}
