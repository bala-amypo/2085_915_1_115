package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ShipmentRecord;

public interface ShipmentRecordRepository extends JpaRepository<ShipmentRecord,Long>{
    Optional<ShipmentRecord> findByShipmentCode(String shipmentCode);
}