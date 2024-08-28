package com.example.projeto_aguas_fluentes.application.gateways;

import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;

import java.util.List;

public interface AlertRepository {

    Alert recordAlert(Alert alert);

    List<Alert> listAll();
}
