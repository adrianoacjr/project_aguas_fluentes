package com.example.projeto_aguas_fluentes.config;

import com.example.projeto_aguas_fluentes.application.gateways.AlertRepository;
import com.example.projeto_aguas_fluentes.application.gateways.PressureSensorRepository;
import com.example.projeto_aguas_fluentes.application.usecases.ListAlert;
import com.example.projeto_aguas_fluentes.application.usecases.ListPressureSensor;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterAlert;
import com.example.projeto_aguas_fluentes.application.usecases.RegisterPressureSensor;
import com.example.projeto_aguas_fluentes.infra.gateways.AlertEntityMapper;
import com.example.projeto_aguas_fluentes.infra.gateways.AlertJpaRepository;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorEntityMapper;
import com.example.projeto_aguas_fluentes.infra.gateways.PressureSensorJpaRepository;
import com.example.projeto_aguas_fluentes.infra.persistence.AlertInfraRepository;
import com.example.projeto_aguas_fluentes.infra.persistence.PressureSensorInfraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertConfig {

    @Bean
    RegisterAlert registerAlert(AlertRepository alertRepository) {
        return new RegisterAlert(alertRepository);
    }

    @Bean
    ListAlert listAlert(AlertRepository alertRepository) {
        return new ListAlert(alertRepository);
    }

    @Bean
    AlertJpaRepository createAlertJpaRepository(AlertInfraRepository repository, AlertEntityMapper mapper) {
        return new AlertJpaRepository(repository, mapper);
    }

    @Bean
    AlertEntityMapper getAlertMapper() {
        return new AlertEntityMapper();
    }
}
