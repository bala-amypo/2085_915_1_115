package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to ShipmentRecord
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRecord shipment;

    @Column(name = "alert_type")
    private String alertType;

    @Column(name = "alert_time")
    private LocalDateTime alertTime;

    @Column(name = "message")
    private String message;

    public AlertRecord() {}

    public AlertRecord(ShipmentRecord shipment, String alertType, LocalDateTime alertTime, String message) {
        this.shipment = shipment;
        this.alertType = alertType;
        this.alertTime = alertTime;
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
