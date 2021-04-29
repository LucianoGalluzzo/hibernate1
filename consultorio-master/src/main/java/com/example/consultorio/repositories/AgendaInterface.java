package com.example.consultorio.repositories;

import com.example.consultorio.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendaInterface extends JpaRepository<Agenda, Integer> {

    public List<Agenda> findByDate(LocalDate date);
}
