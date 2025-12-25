package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "temperature_sensor_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Double temperatureValue;
    private String location;

    public TemperatureSensorLog() {}

    // ===== GETTERS =====
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Double getTemperatureValue() { return temperatureValue; }
    public String getLocation() { return location; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }
    public void setLocation(String location) { this.location = location; }
}
