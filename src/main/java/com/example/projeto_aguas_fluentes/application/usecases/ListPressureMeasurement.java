package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.PressureMeasurementRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;

import java.util.List;

public class ListPressureMeasurement {

    private final PressureMeasurementRepository repository;

    public ListPressureMeasurement(PressureMeasurementRepository repository) {
        this.repository = repository;
    }

    public List<PressureMeasurement> getAllPressureMeasurements() {
        return this.repository.listAll();
    }
}
