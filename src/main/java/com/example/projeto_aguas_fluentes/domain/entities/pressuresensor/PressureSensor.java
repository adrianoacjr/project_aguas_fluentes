package com.example.projeto_aguas_fluentes.domain.entities.pressuresensor;

import com.example.projeto_aguas_fluentes.domain.Address;

import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.Status;

import java.time.LocalDate;

public class PressureSensor {

    private Long id;

    private Address location;

    private Status status;

    private LocalDate lastCalibrationDate;

    private PressureThresholds pressureThresholds;

    public PressureSensor(Address location, Status status, LocalDate lastCalibrationDate, PressureThresholds pressureThresholds) {
        if (location == null) {
            throw new IllegalArgumentException("Localização não fornecida!");
        }

        this.location = location;
        this.status = status;
        this.lastCalibrationDate = lastCalibrationDate;
        this.pressureThresholds = pressureThresholds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getLastCalibrationDate() {
        return lastCalibrationDate;
    }

    public void setLastCalibrationDate(LocalDate lastCalibrationDate) {
        this.lastCalibrationDate = lastCalibrationDate;
    }

    public PressureThresholds getPressureThresholds() {
        return pressureThresholds;
    }

    public void setPressureThresholds(PressureThresholds pressureThresholds) {
        this.pressureThresholds = pressureThresholds;
    }
}
