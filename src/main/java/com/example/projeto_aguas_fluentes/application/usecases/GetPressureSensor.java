package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

public class GetPressureSensor {

    private final PressureSensorRepository repository;

    public GetPressureSensor(PressureSensorRepository repository) {
        this.repository = repository;
    }

    public PressureSensor getById() {
        returm this.repository
    }
}
