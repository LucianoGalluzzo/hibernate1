package com.example.consultorio.repositories;

import com.example.consultorio.entity.Dentista;
import com.example.consultorio.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteInterface extends JpaRepository<Paciente, Integer> {
}
