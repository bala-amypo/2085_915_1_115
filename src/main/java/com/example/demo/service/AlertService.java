package com.example.demo.service;

import com.example.demo.entity.AlertRecord;

import java.util.List;
import java.util.Optional;

public interface AlertService {

    AlertRecord triggerAlert(AlertRecord alert);

    AlertRecord acknowledgeAlert(Long id);

    Optional<AlertRecord> getAlertById(Long id);

    List<AlertRecord> getAlertsByShipment(Long shipmentId);

    List<AlertRecord> getAllAlerts();
}
