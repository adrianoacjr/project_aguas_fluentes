package com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement;

import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PressureMeasurement {
    private Long id;

//    private Long sensorId;

    private PressureSensor pressureSensor;

    private LocalDateTime measureTimestamp;

    private BigDecimal pressureValue;

    private PressureStatus status;

    public PressureMeasurement(PressureSensor pressureSensor, LocalDateTime measureTimestamp, BigDecimal pressureValue) {
        this.pressureSensor = pressureSensor;
        this.measureTimestamp = measureTimestamp;
        this.pressureValue = pressureValue;
        this.checkPressureValue(pressureSensor, pressureValue);
    }

    public void checkPressureValue(PressureSensor pressureSensor, BigDecimal pressureValue) {
        PressureThresholds pressureSensorThresholds = pressureSensor.getPressureThresholds();
        BigDecimal minimumValue = pressureSensorThresholds.getMinimumThreshold();
        BigDecimal maximumValue = pressureSensorThresholds.getMaximumThreshold();
        if (pressureValue.compareTo(minimumValue) < 0 || pressureValue.compareTo(maximumValue) > 0){
            this.status = PressureStatus.values()[1];
        } else {
            this.status = PressureStatus.values()[0];
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PressureSensor getPressureSensor() {
        return pressureSensor;
    }

    public void setPressureSensor(PressureSensor pressureSensor) {
        this.pressureSensor = pressureSensor;
    }

    public LocalDateTime getMeasureTimestamp() {
        return measureTimestamp;
    }

    public void setMeasureTimestamp(LocalDateTime measureTimestamp) {
        this.measureTimestamp = measureTimestamp;
    }

    public BigDecimal getPressureValue() {
        return pressureValue;
    }

    public void setPressureValue(BigDecimal pressureValue) {
        this.pressureValue = pressureValue;
    }

    public PressureStatus getStatus() {
        return status;
    }

    public void setStatus(PressureStatus status) {
        this.status = status;
    }
}
