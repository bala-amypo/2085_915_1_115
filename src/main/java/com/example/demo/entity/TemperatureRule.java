package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "temperature_rules")
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private Double minTemp;
    private Double maxTemp;
    private Boolean active;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public TemperatureRule() {}

    @PrePersist
    public void prePersist() {
        if (this.active == null) {
            this.active = true;
        }
    }

    // ===== REQUIRED BY TESTS =====
    public boolean isActive() {
        return Boolean.TRUE.equals(active);
    }

    public boolean getActive() {
        return Boolean.TRUE.equals(active);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public String getProductType() { return productType; }
    public Double getMinTemp() { return minTemp; }
    public Double getMaxTemp() { return maxTemp; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }

    public void setId(Long id) { this.id = id; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
}
