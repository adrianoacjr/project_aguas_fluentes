package com.example.projeto_aguas_fluentes.domain.entities.pressuresensor;

import com.example.projeto_aguas_fluentes.domain.Address;

import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.Status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PressureSensorTest {
    @Test
    public void shouldNotCreateWithInvalidFormat() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new PressureSensor(null, Status.OPERATIONAL, LocalDate.parse("2024-08-24"), new PressureThresholds()));
    }

    @Test
    public void mustIncludeAddressWithStreet() {
        PressureSensorBuilder builder = new PressureSensorBuilder();

        PressureSensor pressureSensor = builder.withoutLocation(0L, Status.OPERATIONAL, LocalDate.parse("2024-08-24"), new PressureThresholds());

        Assertions.assertEquals("", pressureSensor.getLocation().getStreet());

        pressureSensor = builder.includeAddress("Rua Gonçalo", "Mogi das Cruzes", "São Paulo", "08770-000", "Brasil");

        Assertions.assertEquals("Rua Gonçalo", pressureSensor.getLocation().getStreet());

    }
}
