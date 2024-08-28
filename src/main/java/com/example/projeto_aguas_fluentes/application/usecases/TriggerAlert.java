package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.domain.AlertStatus;
import com.example.projeto_aguas_fluentes.domain.AlertType;
import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TriggerAlert {

    private final AlertRepository repository;

    public TriggerAlert(AlertRepository repository) {
        this.repository = repository;
    }

    public Alert sendAlert(PressureMeasurement pressureMeasurement) {

        if (pressureMeasurement.getStatus() == PressureStatus.values()[1]) {
            System.out.println("Alerta: Pressão fora dos limites no sensor ID: "
                    + pressureMeasurement.getPressureSensor().getId());

            BigDecimal minimumValue = pressureMeasurement.getPressureSensor().getPressureThresholds().getMinimumThreshold();

            BigDecimal maximumValue = pressureMeasurement.getPressureSensor().getPressureThresholds().getMaximumThreshold();

            int alertType;
            if (pressureMeasurement.getPressureValue().compareTo(minimumValue) < 0) {
                alertType = 0;
            } else if (pressureMeasurement.getPressureValue().compareTo(maximumValue) > 0) {
                alertType = 1;
            } else {
                alertType = 2;
            }

            if (pressureMeasurement.getStatus() == PressureStatus.values()[1]) {
                System.out.println("       Registo do tipo: "
                        + AlertType.values()[alertType]);
                return repository.recordAlert(new Alert(pressureMeasurement.getId(),
                        AlertType.values()[alertType], LocalDateTime.now(), AlertStatus.values()[1]));
            }
        }
        return new Alert(pressureMeasurement.getId(),
                AlertType.values()[0], LocalDateTime.now(), AlertStatus.values()[1]);
    }
}
