package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.application.usecases.ListPressureSensor;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterPressureSensor;
import com.example.projeto_aguas_fluentes.domain.Address;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pressuresensor")
public class PressureSensorController {

    private final RegisterPressureSensor registerPressuresensor;

    private final ListPressureSensor listPressureSensor;

    public PressureSensorController(
            RegisterPressureSensor registerPressuresensor,
            ListPressureSensor listPressureSensor) {
        this.registerPressuresensor = registerPressuresensor;
        this.listPressureSensor = listPressureSensor;
    }

    @PostMapping
    public PressureSensorDto recordPressureSensor(@RequestBody PressureSensorDto dto) {
        Address location = new Address(dto.street(), dto.city(),dto.state(),
                dto.postalCode(), dto.country());

        PressureThresholds pressureThresholds = new PressureThresholds(dto.minimumThreshold(),
                dto.maximumThreshold());

        PressureSensor recorded = registerPressuresensor.recordPressureSensor(new PressureSensor(location, dto.status(),
                dto.lastCalibrationDate(), pressureThresholds));

        return new PressureSensorDto(
                recorded.getLocation().getStreet(),
                recorded.getLocation().getCity(),
                recorded.getLocation().getState(),
                recorded.getLocation().getPostalCode(),
                recorded.getLocation().getCountry(),
                recorded.getStatus(),
                recorded.getLastCalibrationDate(),
                recorded.getPressureThresholds().getMinimumThreshold(),
                recorded.getPressureThresholds().getMaximumThreshold());
    }

    @GetMapping
    public List<PressureSensorDto> listPressureSensor() {
        return listPressureSensor.getAllPressureSensors().stream()
                .map(u -> new PressureSensorDto(
                        u.getLocation().getStreet(),
                        u.getLocation().getCity(),
                        u.getLocation().getState(),
                        u.getLocation().getPostalCode(),
                        u.getLocation().getCountry(),
                        u.getStatus(),
                        u.getLastCalibrationDate(),
                        u.getPressureThresholds().getMinimumThreshold(),
                        u.getPressureThresholds().getMaximumThreshold()))
                .collect(Collectors.toList());
    }
}
