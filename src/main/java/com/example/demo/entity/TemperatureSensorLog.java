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
    private Double temperatureValue;
    private LocalDateTime recordedAt;
    private String location;

    public TemperatureSensorLog() {
    }

    public TemperatureSensorLog(Long shipmentId, Double temperatureValue,
                                LocalDateTime recordedAt, String location) {
        this.shipmentId = shipmentId;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.location = location;
    }

    @PrePersist
    public void prePersist() {
        if (recordedAt == null) {
            recordedAt = LocalDateTime.now();
        }
    }

    public Long getShipmentId() { return shipmentId; }
    public Double getTemperatureValue() { return temperatureValue; }
    public String getLocation() { return location; }
}
