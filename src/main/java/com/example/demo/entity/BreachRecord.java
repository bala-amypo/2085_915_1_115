package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long logId;

    private String breachType;
    private Double breachValue;
    private String severity;
    private String details;

    private LocalDateTime detectedAt;
    private Boolean resolved;

    public BreachRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // ===== REQUIRED BY TESTS =====
    public boolean getResolved() {
        return Boolean.TRUE.equals(resolved);
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Long getLogId() { return logId; }
    public String getBreachType() { return breachType; }
    public Double getBreachValue() { return breachValue; }
    public String getSeverity() { return severity; }
    public String getDetails() { return details; }
    public LocalDateTime getDetectedAt() { return detectedAt; }

    public void setId(Long id) { this.id = id; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setLogId(Long logId) { this.logId = logId; }
    public void setBreachType(String breachType) { this.breachType = breachType; }
    public void setBreachValue(Double breachValue) { this.breachValue = breachValue; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setDetails(String details) { this.details = details; }
}
