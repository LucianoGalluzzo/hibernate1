package com.example.consultorio.repositories;

import com.example.consultorio.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaInterface extends JpaRepository<Agenda, Integer> {
}
