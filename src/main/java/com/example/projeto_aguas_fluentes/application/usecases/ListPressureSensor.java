package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

import java.util.List;

public class ListPressureSensor {

    private final PressureSensorRepository repository;

    public ListPressureSensor(PressureSensorRepository repository) {
        this.repository = repository;
    }

    public List<PressureSensor> getAllPressureSensors() {
        return this.repository.listAll();
    }
}
