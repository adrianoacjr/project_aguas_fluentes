package com.example.projeto_aguas_fluentes.infra.gateways;

import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorEntity;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorInfraRepository;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PressureSensorJpaRepository implements PressureSensorRepository {

    private final PressureSensorInfraRepository repository;

    private final PressureSensorEntityMapper mapper;

    public PressureSensorJpaRepository(PressureSensorInfraRepository repository, PressureSensorEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PressureSensor recordPressureSensor(PressureSensor pressureSensor) {
        PressureSensorEntity entity = mapper.toEntity(pressureSensor);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<PressureSensor> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public PressureSensor getById(Long sensorId) {
        PressureSensorEntity pressureSensorEntity = repository.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Pressure Sensor not found"));

        PressureSensor pressureSensor = mapper.toDomain(pressureSensorEntity);

        pressureSensor.setId(sensorId);

        return pressureSensor;
    }
}
