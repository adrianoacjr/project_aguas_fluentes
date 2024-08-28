package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.application.gateways.PressureMeasurementRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuremeasurement.PressureMeasurement;
import com.example.projeto_aguas_fluentes.application.usecases.TriggerAlert;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureMeasurementEntity;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureMeasurementInfraRepository;
import org.hibernate.query.sqm.TrimSpec;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.concurrent.Executor;

public class PressureMeasurementJpaRepository implements PressureMeasurementRepository {

    private final PressureMeasurementInfraRepository repository;

    private final AlertRepository alertRepository;

    private final PressureMeasurementEntityMapper mapper;

    private final Executor executor;

    public PressureMeasurementJpaRepository(PressureMeasurementInfraRepository repository, AlertRepository alertRepository, PressureMeasurementEntityMapper mapper, Executor executor) {
        this.repository = repository;
        this.alertRepository = alertRepository;
        this.mapper = mapper;
        this.executor = executor;
    }

    @Override
    @Async
    public CompletableFuture<PressureMeasurement> recordPressureMeasurement(PressureMeasurement pressureMeasurement) {
        PressureMeasurementEntity entity = mapper.toEntity(pressureMeasurement);

        repository.save(entity);

        TriggerAlert triggerAlert = new TriggerAlert(alertRepository);

        CompletableFuture.runAsync(() -> triggerAlert.sendAlert(pressureMeasurement), executor);

        return CompletableFuture.completedFuture(mapper.toDomain(entity));
    }

    @Override
    public List<PressureMeasurement> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
