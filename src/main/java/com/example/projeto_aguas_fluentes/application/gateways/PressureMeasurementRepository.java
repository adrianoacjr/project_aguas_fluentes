package com.example.projeto_aguas_fluentes.application.gateways;

import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PressureMeasurementRepository {

    CompletableFuture<PressureMeasurement> recordPressureMeasurement(PressureMeasurement pressureMeasurement);

    List<PressureMeasurement> listAll();
}
