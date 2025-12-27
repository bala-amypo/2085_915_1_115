package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "shipment_records",
    uniqueConstraints = @UniqueConstraint(columnNames = "shipmentCode")
)
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private String origin;
    private String destination;
    private String productType;

    private LocalDateTime startDate;
    private LocalDateTime expectedDelivery;

    private String status;
    private LocalDateTime createdAt;

    public ShipmentRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = "IN_TRANSIT";
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getShipmentCode() { return shipmentCode; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getProductType() { return productType; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getExpectedDelivery() { return expectedDelivery; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public void setExpectedDelivery(LocalDateTime expectedDelivery) { this.expectedDelivery = expectedDelivery; }
    public void setStatus(String status) { this.status = status; }
}
