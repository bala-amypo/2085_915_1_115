package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatureValue;
    private LocalDateTime recordedAt;
    private String location;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private ShipmentRecord shipment;

    public TemperatureSensorLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentRecord shipment) {
        this.shipment = shipment;
    }

    public TemperatureSensorLog(Long id, Double temperatureValue, LocalDateTime recordedAt, String location,
            ShipmentRecord shipment) {
        this.id = id;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.location = location;
        this.shipment = shipment;
    }

    
}
