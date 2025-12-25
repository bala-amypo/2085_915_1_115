package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shipment_records")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private String origin;
    private String destination;
    private String status;

    public ShipmentRecord() {}

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "CREATED";
        }
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getShipmentCode() { return shipmentCode; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStatus() { return status; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setStatus(String status) { this.status = status; }
}
