package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.PressureMeasurementRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;

import java.util.concurrent.CompletableFuture;

public class RegisterPressureMeasurement {
    private final PressureMeasurementRepository repository;

    public RegisterPressureMeasurement(PressureMeasurementRepository repository) {
        this.repository = repository;
    }

    public CompletableFuture<PressureMeasurement> recordPressureMeasurement(PressureMeasurement pressureMeasurement) {
        return repository.recordPressureMeasurement(pressureMeasurement);
    }
}
