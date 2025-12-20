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

    @GetMapping("/code/{shipmentCode}")
    public ShipmentRecord getShipmentByCode(
            @PathVariable String shipmentCode) {
        return shipmentService.getShipmentByCode(shipmentCode);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return shipmentService.getAllShipments();
    }
}
