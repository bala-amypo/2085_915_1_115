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

    private String alertType;
    private String message;

    private LocalDateTime sentAt;
    private Boolean acknowledged;

    public AlertRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.sentAt == null) {
            this.sentAt = LocalDateTime.now();
        }
        if (this.acknowledged == null) {
            this.acknowledged = false;
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Long getBreachId() { return breachId; }
    public String getAlertType() { return alertType; }
    public String getMessage() { return message; }
    public LocalDateTime getSentAt() { return sentAt; }
    public Boolean getAcknowledged() { return acknowledged; }

    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setBreachId(Long breachId) { this.breachId = breachId; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    public void setMessage(String message) { this.message = message; }
    public void setAcknowledged(Boolean acknowledged) { this.acknowledged = acknowledged; }
}
