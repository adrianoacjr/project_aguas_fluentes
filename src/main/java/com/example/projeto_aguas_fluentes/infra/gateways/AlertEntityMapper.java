package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;
import com.example.projeto_aguas_fluentes.infra.persistence.AlertEntity;

public class AlertEntityMapper {

    public AlertEntity toEntity(Alert alert) {
        return new AlertEntity(alert.getPressureMeasurement(), alert.getAlertType(),
                alert.getAlertTimestamp(), alert.getStatus());
    }

    public Alert toDomain(AlertEntity entity) {
        return new Alert(entity.getPressureMeasurement(), entity.getAlertType(), entity.getAlertTimestamp(),
                entity.getStatus());
    }
}
