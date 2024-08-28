package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.PressureStatus;
import com.example.projeto_aguas_fluentes.domain.PressureThresholds;
import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PressureSensorInfraRepository extends  JpaRepository<PressureSensorEntity, Long> {
}
