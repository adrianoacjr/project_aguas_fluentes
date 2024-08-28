package com.example.projeto_aguas_fluentes.domain.entities.pressuresensor;

import com.example.projeto_aguas_fluentes.domain.Address;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.Status;

import java.time.LocalDate;

public class PressureSensorBuilder {
    private PressureSensor pressureSensor;

    public PressureSensor withoutLocation(Long id, Status status, LocalDate lastCalibrationDate, PressureThresholds pressureThresholds) {
        Address location = new Address("", "", "", "", "");
        this.pressureSensor = new PressureSensor(location, status, lastCalibrationDate, pressureThresholds);
        return this.pressureSensor;
    }

    public PressureSensor includeAddress(String street, String city, String state, String postalCode, String country) {
        this.pressureSensor.setLocation(new Address(street, city, state, postalCode, country));
        return this.pressureSensor;
    }
}
