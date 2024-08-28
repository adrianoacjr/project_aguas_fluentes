package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

public class RegisterPressureSensor {

    private final PressureSensorRepository repository;

    public RegisterPressureSensor(PressureSensorRepository repository) {
        this.repository = repository;
    }

    public PressureSensor recordPressureSensor(PressureSensor pressureSensor) {
        return repository.recordPressureSensor(pressureSensor);
    }
}
