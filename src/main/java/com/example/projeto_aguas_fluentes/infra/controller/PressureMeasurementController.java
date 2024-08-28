package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.application.usecases.GetPressureSensor;
import com.example.projeto_aguas_fluentes.application.usecases.ListPressureMeasurement;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterPressureMeasurement;
import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pressuremeasurement")
public class PressureMeasurementController {

    private final RegisterPressureMeasurement registerPressureMeasurement;

    private final ListPressureMeasurement listPressureMeasurement;

    private final GetPressureSensor getPressureSensor;

    public PressureMeasurementController(RegisterPressureMeasurement registerPressureMeasurement,
                                         ListPressureMeasurement listPressureMeasurement,
                                         GetPressureSensor getPressureSensor) {
        this.registerPressureMeasurement = registerPressureMeasurement;
        this.listPressureMeasurement = listPressureMeasurement;
        this.getPressureSensor = getPressureSensor;
    }

    @PostMapping
    public PressureMeasurementDto recordPressureMeasurement(@RequestBody PressureMeasurementDto dto) {
        PressureSensor pressureSensor = getPressureSensor.getSensorById(dto.sensorId());

        CompletableFuture<PressureMeasurement> recordedFuture = registerPressureMeasurement.recordPressureMeasurement(new PressureMeasurement(
                    pressureSensor, dto.measureTimestamp(), dto.pressureValue()));

        PressureMeasurement recorded;
        try {
            recorded = recordedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to record pressure measurement", e);
        }

        return new PressureMeasurementDto(recorded.getPressureSensor().getId(), recorded.getMeasureTimestamp(),
                recorded.getPressureValue(), recorded.getStatus());
    }

    @GetMapping
    public List<PressureMeasurementDto> listPressureMeasurement() {
        return listPressureMeasurement.getAllPressureMeasurements().stream()
                .map(u -> new PressureMeasurementDto(u.getPressureSensor().getId(), u.getMeasureTimestamp(),
                        u.getPressureValue(), u.getStatus()))
                .collect(Collectors.toList());
    }
}
