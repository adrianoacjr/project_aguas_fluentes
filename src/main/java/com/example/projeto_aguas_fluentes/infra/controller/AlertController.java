package com.example.projeto_aguas_fluentes.infra.controller;

import com.example.projeto_aguas_fluentes.application.usecases.ListAlert;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterAlert;
import com.example.projeto_aguas_fluentes.domain.AlertStatus;
import com.example.projeto_aguas_fluentes.domain.AlertType;
import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alert")
public class AlertController {

    private final RegisterAlert registerAlert;

    private final ListAlert listAlert;

    public AlertController(RegisterAlert registerAlert, ListAlert listAlert) {
        this.registerAlert = registerAlert;
        this.listAlert = listAlert;
    }

    @PostMapping
    public AlertDto recordAlert(@RequestBody AlertDto dto) {

        Alert recorded = registerAlert.recordAlert(new Alert(dto.pressureMeasurement(), dto.alertType(),
                dto.alertTimestamp(), dto.status()));

        return new AlertDto(
                recorded.getPressureMeasurement(),
                recorded.getAlertType(),
                recorded.getAlertTimestamp(),
                recorded.getStatus());
    }

    @GetMapping
    public List<AlertDto> listAlert() {
        return listAlert.getAllAlerts().stream()
                .map(u -> new AlertDto(
                        u.getPressureMeasurement(),
                        u.getAlertType(),
                        u.getAlertTimestamp(),
                        u.getStatus()))
                .collect(Collectors.toList());
    }
}
