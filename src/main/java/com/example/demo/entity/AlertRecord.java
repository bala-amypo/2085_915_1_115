package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private boolean acknowledged;

    public AlertRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getBreachId() { return breachId; }
    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public boolean isAcknowledged() { return acknowledged; }
    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
}
