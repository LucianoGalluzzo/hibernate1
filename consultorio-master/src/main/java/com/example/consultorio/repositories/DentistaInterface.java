package com.example.consultorio.repositories;

import com.example.consultorio.entity.Agenda;
import com.example.consultorio.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaInterface extends JpaRepository<Dentista, Integer> {
}
