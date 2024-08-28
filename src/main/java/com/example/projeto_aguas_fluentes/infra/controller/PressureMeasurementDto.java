package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.domain.PressureStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PressureMeasurementDto(
        Long sensorId,

        LocalDateTime measureTimestamp,

        BigDecimal pressureValue,

        PressureStatus status
) {

}
