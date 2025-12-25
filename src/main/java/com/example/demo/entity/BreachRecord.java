package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class BreachRecord {

    @Id
    @GeneratedValue
    private Long id;

    private boolean resolved;

    @PrePersist
    public void prePersist() {
        resolved = false;
    }

    public boolean getResolved() {
        return resolved;
    }
}
