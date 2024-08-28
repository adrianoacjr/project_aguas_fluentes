package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;

public class RegisterAlert {

    private final AlertRepository repository;

    public RegisterAlert(AlertRepository repository) {
        this.repository = repository;
    }

    public Alert recordAlert(Alert alert) {
        return repository.recordAlert(alert);
    }
}
