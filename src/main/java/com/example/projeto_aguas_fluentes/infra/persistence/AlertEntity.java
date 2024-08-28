package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.AlertStatus;
import com.example.projeto_aguas_fluentes.domain.AlertType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pressureMeasurement;

    private AlertType alertType;

    private LocalDateTime alertTimestamp;

    private AlertStatus status;

    public AlertEntity() {
    }

    public AlertEntity(Long pressureMeasurement, AlertType alertType, LocalDateTime alertTimestamp, AlertStatus status) {
        this.pressureMeasurement = pressureMeasurement;
        this.alertType = alertType;
        this.alertTimestamp = alertTimestamp;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPressureMeasurement() {
        return pressureMeasurement;
    }

    public void setPressureMeasurement(Long pressureMeasurement) {
        this.pressureMeasurement = pressureMeasurement;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public LocalDateTime getAlertTimestamp() {
        return alertTimestamp;
    }

    public void setAlertTimestamp(LocalDateTime alertTimestamp) {
        this.alertTimestamp = alertTimestamp;
    }

    public AlertStatus getStatus() {
        return status;
    }

    public void setStatus(AlertStatus status) {
        this.status = status;
    }
}
