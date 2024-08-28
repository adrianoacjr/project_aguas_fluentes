package com.example.projeto_aguas_fluentes.config;

import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.application.usecases.ListPressureSensor;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterPressureSensor;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorEntityMapper;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorJpaRepository;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorInfraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PressureSensorConfig {

    @Bean
    RegisterPressureSensor registerPressureSensor(PressureSensorRepository pressureSensorRepository) {
        return new RegisterPressureSensor(pressureSensorRepository);
    }

    @Bean
    ListPressureSensor listPressureSensor(PressureSensorRepository pressureSensorRepository) {
        return new ListPressureSensor(pressureSensorRepository);
    }

    @Bean
    PressureSensorJpaRepository createJpaRepository(PressureSensorInfraRepository repository, PressureSensorEntityMapper mapper) {
        return new PressureSensorJpaRepository(repository, mapper);
    }

    @Bean
    PressureSensorEntityMapper getMapper() {
        return new PressureSensorEntityMapper();
    }
}
