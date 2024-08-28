package com.example.projeto_aguas_fluentes.config;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.application.gateways.PressureMeasurementRepository;
import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.application.usecases.*;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureMeasurementEntityMapper;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureMeasurementJpaRepository;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorEntityMapper;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorJpaRepository;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureMeasurementInfraRepository;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorInfraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class PressureMeasurementConfig {

    @Bean
    RegisterPressureMeasurement registerPressureMeasurement(PressureMeasurementRepository pressureMeasurementRepository) {
        return new RegisterPressureMeasurement(pressureMeasurementRepository);
    }

    @Bean
    ListPressureMeasurement listPressureMeasurement(PressureMeasurementRepository pressureMeasurementRepository) {
        return new ListPressureMeasurement(pressureMeasurementRepository);
    }

    @Bean
    GetPressureSensor getPressureSensor(PressureSensorRepository pressureSensorRepository) {
        return new GetPressureSensor(pressureSensorRepository);
    }

    @Bean
    PressureMeasurementJpaRepository createPressureMeasurementJpaRepository(PressureMeasurementInfraRepository repository, AlertRepository alertRepository, PressureMeasurementEntityMapper mapper, Executor executor) {
        return new PressureMeasurementJpaRepository(repository, alertRepository, mapper, executor);
    }

    @Bean
    PressureMeasurementEntityMapper getPressureMeasurementMapper(GetPressureSensor getPressureSensor) {
        return new PressureMeasurementEntityMapper(getPressureSensor);
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newFixedThreadPool(10); // Adjust the pool size as needed
    }

}
