package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.domain.AlertStatus;
import com.example.projeto_aguas_fluentes.domain.AlertType;

import java.time.LocalDateTime;

public record AlertDto(
        Long pressureMeasurement,

        AlertType alertType,

        LocalDateTime alertTimestamp,

        AlertStatus status
) {
}
