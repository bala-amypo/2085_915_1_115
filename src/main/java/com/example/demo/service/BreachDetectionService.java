package com.example.demo.service;

import com.example.demo.entity.BreachRecord;

import java.util.List;
import java.util.Optional;

public interface BreachDetectionService {

    BreachRecord logBreach(BreachRecord breach);

    BreachRecord resolveBreach(Long id);

    Optional<BreachRecord> getBreachById(Long id);

    List<BreachRecord> getBreachesByShipment(Long shipmentId);

    List<BreachRecord> getAllBreaches();
}
