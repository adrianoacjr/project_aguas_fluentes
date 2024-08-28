package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.application.usecases.GetPressureSensor;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureMeasurementEntity;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorEntity;

public class PressureMeasurementEntityMapper {

    private final GetPressureSensor getPressureSensor;

    public PressureMeasurementEntityMapper(GetPressureSensor getPressureSensor) {
        this.getPressureSensor = getPressureSensor;
    }

    public PressureMeasurementEntity toEntity(PressureMeasurement pressureMeasurement) {
        PressureMeasurementEntity pressureMeasurementEntity = new PressureMeasurementEntity(pressureMeasurement.getPressureSensor().getId(), pressureMeasurement.getMeasureTimestamp(),
                pressureMeasurement.getPressureValue(), pressureMeasurement.getStatus());
        pressureMeasurementEntity.setId(pressureMeasurement.getId());
        return pressureMeasurementEntity;
    }

    public PressureMeasurement toDomain(PressureMeasurementEntity entity) {
        PressureSensor pressureSensor = getPressureSensor.getSensorById(entity.getSensorId());
        return new PressureMeasurement(pressureSensor, entity.getMeasureTimestamp(),
                entity.getPressureValue());
    }
}
