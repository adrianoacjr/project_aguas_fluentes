package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pressure_sensors")
public class PressureSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Status status;

    private LocalDate lastCalibrationDate;

    private BigDecimal minimumThreshold;

    private BigDecimal maximumThreshold;

    public PressureSensorEntity() {
    }

    public PressureSensorEntity(String street, String city, String state, String postalCode, String country, Status status, LocalDate lastCalibrationDate, BigDecimal minimumThreshold, BigDecimal maximumThreshold) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.status = status;
        this.lastCalibrationDate = lastCalibrationDate;
        this.minimumThreshold = minimumThreshold;
        this.maximumThreshold = maximumThreshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public BigDecimal getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(BigDecimal minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public BigDecimal getMaximumThreshold() {
        return maximumThreshold;
    }

    public void setMaximumThreshold(BigDecimal maximumThreshold) {
        this.maximumThreshold = maximumThreshold;
    }
}
