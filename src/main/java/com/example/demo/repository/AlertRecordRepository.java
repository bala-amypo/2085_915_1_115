package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AlertRecord;

public interface AlertRecordRepository extends JpaRepository<AlertRecord,Long>{
     List<AlertRecord> findByShipmentId(Long shipmentId);
} 
