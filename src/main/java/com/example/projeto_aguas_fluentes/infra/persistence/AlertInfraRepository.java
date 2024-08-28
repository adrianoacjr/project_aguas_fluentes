package com.example.projeto_aguas_fluentes.infra.persistence;

import com.example.projeto_aguas_fluentes.domain.entities.alert.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertInfraRepository extends JpaRepository<AlertEntity, Long> {
}
