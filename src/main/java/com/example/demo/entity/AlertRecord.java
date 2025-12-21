package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long shipmentId;

    @Column(nullable = false)
    private Long breachId;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String message;

    private LocalDateTime sentAt;

    private Boolean acknowledged;

    public AlertRecord() {
    }

    @PrePersist
    public void onCreate() {
        this.sentAt = LocalDateTime.now();
        if (this.acknowledged == null) {
            this.acknowledged = false;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getBreachId() {
        return breachId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public AlertRecord(Long id, Long shipmentId, Long breachId, String alertType, String message, LocalDateTime sentAt,
            Boolean acknowledged) {
        this.id = id;
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.alertType = alertType;
        this.message = message;
        this.sentAt = sentAt;
        this.acknowledged = acknowledged;
    }
    
}
