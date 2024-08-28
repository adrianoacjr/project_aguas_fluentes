package com.example.projeto_aguas_fluentes.application.gateways;

import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

import java.util.List;
import java.util.Optional;

public interface PressureSensorRepository {

    PressureSensor recordPressureSensor(PressureSensor pressureSensor);

    List<PressureSensor> listAll();

    PressureSensor getById(Long sensorId);
}
