package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double breachValue;
    private String severity;
    private boolean resolved;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private ShipmentRecord shipment;

    @ManyToOne
    @JoinColumn(name = "log_id")
    private TemperatureSensorLog temperatureLog;

    @PrePersist
    public void prePersist() {
        resolved = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBreachValue() {
        return breachValue;
    }

    public void setBreachValue(Double breachValue) {
        this.breachValue = breachValue;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentRecord shipment) {
        this.shipment = shipment;
    }

    public TemperatureSensorLog getTemperatureLog() {
        return temperatureLog;
    }

    public void setTemperatureLog(TemperatureSensorLog temperatureLog) {
        this.temperatureLog = temperatureLog;
    }

    public BreachRecord(Long id, Double breachValue, String severity, boolean resolved, ShipmentRecord shipment,
            TemperatureSensorLog temperatureLog) {
        this.id = id;
        this.breachValue = breachValue;
        this.severity = severity;
        this.resolved = resolved;
        this.shipment = shipment;
        this.temperatureLog = temperatureLog;
    }

    public BreachRecord() {
    }

}
