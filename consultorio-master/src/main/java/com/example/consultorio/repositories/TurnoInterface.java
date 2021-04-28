package com.example.consultorio.repositories;

import com.example.consultorio.entity.Paciente;
import com.example.consultorio.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoInterface extends JpaRepository<Turno, Integer> {
}
