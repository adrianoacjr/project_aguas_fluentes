package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pressure_measurements")
public class PressureMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sensorId;

    private LocalDateTime measureTimestamp;

    private BigDecimal pressureValue;

    private PressureStatus status;

    public PressureMeasurementEntity() {
    }

    public PressureMeasurementEntity(Long sensorId, LocalDateTime measureTimestamp, BigDecimal pressureValue, PressureStatus status) {
        this.sensorId = sensorId;
        this.measureTimestamp = measureTimestamp;
        this.pressureValue = pressureValue;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
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
