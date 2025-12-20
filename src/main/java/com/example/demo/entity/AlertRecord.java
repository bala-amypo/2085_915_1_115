package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with Shipment
    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRecord shipment;

    @Column(nullable = false)
    private String alertType;   // TEMPERATURE_BREACH, SENSOR_FAILURE, etc.

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime alertTime;

    @Column(nullable = false)
    private boolean acknowledged = false;

    /* ================== Constructors ================== */

    public AlertRecord() {
        this.alertTime = LocalDateTime.now();
    }

    /* ================== Getters and Setters ================== */

    public Long getId() {
        return id;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentRecord shipment) {
        this.shipment = shipment;
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

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
}
