package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shipment_records")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private String origin;
    private String destination;
    private String status;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<TemperatureSensorLog> temperatureLogs;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<BreachRecord> breaches;

    public ShipmentRecord() {}

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "IN_TRANSIT";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TemperatureSensorLog> getTemperatureLogs() {
        return temperatureLogs;
    }

    public void setTemperatureLogs(List<TemperatureSensorLog> temperatureLogs) {
        this.temperatureLogs = temperatureLogs;
    }

    public List<BreachRecord> getBreaches() {
        return breaches;
    }

    public void setBreaches(List<BreachRecord> breaches) {
        this.breaches = breaches;
    }

    public ShipmentRecord(Long id, String shipmentCode, String origin, String destination, String status,
            List<TemperatureSensorLog> temperatureLogs, List<BreachRecord> breaches) {
        this.id = id;
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.temperatureLogs = temperatureLogs;
        this.breaches = breaches;
    }


}
