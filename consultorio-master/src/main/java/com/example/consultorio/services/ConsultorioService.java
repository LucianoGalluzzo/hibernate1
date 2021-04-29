package com.example.consultorio.services;


import com.example.consultorio.dto.DentistaDTO;
import com.example.consultorio.dto.PacienteDTO;
import com.example.consultorio.dto.ReservaDTO;
import com.example.consultorio.dto.ResponseDTO;

import java.text.ParseException;
import java.util.List;

public interface ConsultorioService {

    public void crearPaciente(PacienteDTO paciente);

    public void crearDentista(DentistaDTO dentista);

    public ResponseDTO reservar(ReservaDTO reserva);

    public List<PacienteDTO> verPacientes();

    public List<DentistaDTO> verDentistas();

    public List<PacienteDTO> listarPacientesPorDia(String dia) throws ParseException;


}
