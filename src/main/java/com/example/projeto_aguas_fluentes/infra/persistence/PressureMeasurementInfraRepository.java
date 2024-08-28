package com.example.projeto_aguas_fluentes.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PressureMeasurementInfraRepository extends JpaRepository<PressureMeasurementEntity, Long> {
}
