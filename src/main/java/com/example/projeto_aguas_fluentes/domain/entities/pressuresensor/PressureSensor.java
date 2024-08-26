package com.example.projeto_aguas_fluentes.domain;

import java.time.LocalDate;

public class PressureSensor {
    private Long id;

    private String location;

    private Status status;

    private LocalDate lastCalibrationDate;

    private PressureThresholds pressureThresholds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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
