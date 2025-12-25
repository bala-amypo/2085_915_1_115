package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService shipmentService;

    public ShipmentRecordController(ShipmentRecordService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return shipmentService.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return shipmentService.updateShipmentStatus(id, status);
    }

    @GetMapping("/{code}")
    public Optional<ShipmentRecord> getByCode(@PathVariable String code) {
        return shipmentService.getShipmentByCode(code);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return shipmentService.getAllShipments();
    }
}
