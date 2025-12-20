package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean acknowledged;
    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "breach_id")
    private BreachRecord breach;

    @PrePersist
    public void prePersist() {
        acknowledged = false;
        sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BreachRecord getBreach() {
        return breach;
    }

    public void setBreach(BreachRecord breach) {
        this.breach = breach;
    }

    public AlertRecord(Long id, boolean acknowledged, LocalDateTime sentAt, BreachRecord breach) {
        this.id = id;
        this.acknowledged = acknowledged;
        this.sentAt = sentAt;
        this.breach = breach;
    }

    public AlertRecord() {
    }

}
