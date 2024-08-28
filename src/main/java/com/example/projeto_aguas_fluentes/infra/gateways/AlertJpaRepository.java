package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;
import com.example.projeto_aguas_fluentes.infra.persistence.AlertEntity;
import com.example.projeto_aguas_fluentes.infra.persistence.AlertInfraRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AlertJpaRepository implements AlertRepository {

    private final AlertInfraRepository repository;

    private final AlertEntityMapper mapper;

    public AlertJpaRepository(AlertInfraRepository repository, AlertEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Alert recordAlert(Alert alert) {
        AlertEntity entity = mapper.toEntity(alert);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Alert> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
