package com.henriquedeoliveira_dev.sistema_agenda_spring.repository;

import com.henriquedeoliveira_dev.sistema_agenda_spring.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
}
