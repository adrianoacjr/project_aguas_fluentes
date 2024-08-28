package com.example.projeto_aguas_fluentes.application.usecases;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;

import java.util.List;

public class ListAlert {

    private final AlertRepository repository;

    public ListAlert(AlertRepository repository) {
        this.repository = repository;
    }

    public List<Alert> getAllAlerts() {
        return this.repository.listAll();
    }
}
