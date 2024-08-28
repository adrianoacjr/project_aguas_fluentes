package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.domain.Address;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorEntity;

public class PressureSensorEntityMapper {

    public PressureSensorEntity toEntity(PressureSensor pressureSensor) {
        return new PressureSensorEntity(
                pressureSensor.getLocation().getStreet(),
                pressureSensor.getLocation().getCity(),
                pressureSensor.getLocation().getState(),
                pressureSensor.getLocation().getPostalCode(),
                pressureSensor.getLocation().getCountry(),
                pressureSensor.getStatus(),
                pressureSensor.getLastCalibrationDate(),
                pressureSensor.getPressureThresholds().getMinimumThreshold(),
                pressureSensor.getPressureThresholds().getMaximumThreshold());
    }

    public PressureSensor toDomain(PressureSensorEntity entity) {
        Address location = new Address(entity.getStreet(), entity.getCity(),entity.getState(),
                entity.getPostalCode(), entity.getCountry());

        PressureThresholds pressureThresholds = new PressureThresholds(entity.getMinimumThreshold(),
                entity.getMaximumThreshold());

        return new PressureSensor(location, entity.getStatus(),
                entity.getLastCalibrationDate(), pressureThresholds);
    }
}
