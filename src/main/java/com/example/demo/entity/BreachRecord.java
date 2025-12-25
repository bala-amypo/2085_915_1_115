package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long logId;
    private Double breachValue;
    private String severity;
    private boolean resolved;

    public BreachRecord() {}

    // REQUIRED: tests call this directly
    @PrePersist
    public void prePersist() {
        resolved = false;
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Long getLogId() { return logId; }
    public Double getBreachValue() { return breachValue; }
    public String getSeverity() { return severity; }
    public boolean getResolved() { return resolved; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setLogId(Long logId) { this.logId = logId; }
    public void setBreachValue(Double breachValue) {
        this.breachValue = breachValue;
    }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
