package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertRecord {

    @Id
    @GeneratedValue
    private Long id;

    private boolean acknowledged;
    private LocalDateTime sentAt;

    @PrePersist
    public void prePersist() {
        acknowledged = false;
        sentAt = LocalDateTime.now();
    }

    public boolean getAcknowledged() {
        return acknowledged;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
