package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.entities.pressuresensor.PressureSensor;

public interface PressureSensorRepository  extends  JpaRepository<PressureSensor, Long> {
}
