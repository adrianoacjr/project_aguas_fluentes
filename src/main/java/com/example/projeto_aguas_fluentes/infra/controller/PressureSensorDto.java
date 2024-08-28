package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.domain.Address;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PressureSensorDto(

        String street,

        String city,

        String state,

        String postalCode,

        String country,

        Status status,

        LocalDate lastCalibrationDate,

        BigDecimal minimumThreshold,

        BigDecimal maximumThreshold
) {

}
