package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private String sensorId;
    private LocalDateTime recordedAt;
    private Double temperatureValue;
    private String location;

    public TemperatureSensorLog() {}

    @PrePersist
    public void prePersist() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public String getSensorId() { return sensorId; }
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public Double getTemperatureValue() { return temperatureValue; }
    public String getLocation() { return location; }

    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }
    public void setRecordededAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
    public void setTemperatureValue(Double temperatureValue) { this.temperatureValue = temperatureValue; }
    public void setLocation(String location) { this.location = location; }
}
