package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "alert_records")
public class AlertRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long shipmentId;
    private Long breachId;
    private boolean acknowledged;
    private LocalDateTime sentAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public boolean isAcknowledged() {
        return acknowledged;
    }
    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
    public LocalDateTime getSentAt() {
        return sentAt;
    }
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
    public AlertRecord() {
    }
    public AlertRecord(Long id, Long shipmentId, Long breachId, boolean acknowledged, LocalDateTime sentAt) {
        this.id = id;
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.acknowledged = acknowledged;
        this.sentAt = sentAt;
    }
    @PrePersist
    public void prePersist(){
        this.acknowledged=false;
        if(this.sentAt==null){
            this.sentAt=LocalDateTime.now();
        }
     }
    
}
