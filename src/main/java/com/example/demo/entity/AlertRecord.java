package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private boolean acknowledged;
    private LocalDateTime sentAt;

    public AlertRecord() {}

    // REQUIRED: tests call this explicitly
    @PrePersist
    public void prePersist() {
        acknowledged = false;
        sentAt = LocalDateTime.now();
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Long getBreachId() { return breachId; }
    public boolean getAcknowledged() { return acknowledged; }
    public LocalDateTime getSentAt() { return sentAt; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }
    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }
    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
}
