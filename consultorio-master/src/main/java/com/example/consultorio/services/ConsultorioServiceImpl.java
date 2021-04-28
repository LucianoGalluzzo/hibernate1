package com.example.consultorio.services;

import com.example.consultorio.dto.DentistaDTO;
import com.example.consultorio.dto.PacienteDTO;
import com.example.consultorio.dto.ReservaDTO;
import com.example.consultorio.dto.ResponseDTO;
import com.example.consultorio.entity.Agenda;
import com.example.consultorio.entity.Dentista;
import com.example.consultorio.entity.Paciente;
import com.example.consultorio.entity.Turno;
import com.example.consultorio.repositories.DentistaInterface;
import com.example.consultorio.repositories.PacienteInterface;
import com.example.consultorio.repositories.TurnoInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultorioServiceImpl implements ConsultorioService{

    public final DentistaInterface dentistaRepository;
    public final PacienteInterface pacienteRepository;
    public final TurnoInterface turnoRepository;

    public ConsultorioServiceImpl(DentistaInterface dentistaRepository, PacienteInterface pacienteRepository, TurnoInterface turnoRepository) {
        this.dentistaRepository = dentistaRepository;
        this.pacienteRepository = pacienteRepository;
        this.turnoRepository = turnoRepository;
    }


    @Override
    public void crearPaciente(PacienteDTO paciente) {
        Paciente pacienteEntity = new Paciente(paciente);
        pacienteRepository.save(pacienteEntity);
    }

    @Override
    public void crearDentista(DentistaDTO dentista) {
        Dentista dentistaEntity = new Dentista(dentista);
        dentistaRepository.save(dentistaEntity);
    }

    @Override
    public ResponseDTO reservar(ReservaDTO reserva) {
        Dentista dentista = dentistaRepository.findById(reserva.getId_dentista()).orElse(null);

        if (dentista == null){
            throw new RuntimeException("No existe dentista");
        }

        Paciente paciente = pacienteRepository.findAll().stream().filter(
                p -> p.getDni().equals(reserva.getPaciente().getDni())
        ).findFirst().orElse(null);

        Paciente nuevo = paciente;
        if (paciente == null){
            nuevo = new Paciente(reserva.getPaciente());
            pacienteRepository.save(nuevo);
        }

        Agenda agenda = dentista.getAgendas().stream().filter(
                a -> a.getDate().isEqual(reserva.getDia())
        ).findFirst().orElse(null);

        if(agenda == null)
            throw new RuntimeException("No existe Agenda");

        Turno turno = agenda.getTurnos().stream().filter(
                t -> t.getStart_time().getHour() == reserva.getHora()
                        && t.getStart_time().getMinute() == reserva.getMinutos()
        ).findFirst().orElse(null);

        if(turno == null)
            throw new RuntimeException("No existe turno");

        if (turno.isStatus()){
            throw new RuntimeException("Turno ocupado");
        }

        turno.setPaciente(nuevo);
        turno.setStatus(true);
        turnoRepository.save(turno);

        return new ResponseDTO(200, String.format
                ("La reserva se genero para el paciente %s %s", nuevo.getName(), nuevo.getLast_name()));
    }

    @Override
    public List<PacienteDTO> verPacientes() {
        List<PacienteDTO> listaPacientes = new ArrayList<>();
        List<Paciente> listaPacientesEntity = pacienteRepository.findAll();
        for (int i = 0; i < listaPacientesEntity.size(); i++) {
            listaPacientes.add(new PacienteDTO(listaPacientesEntity.get(i)));
        }

        return listaPacientes;
    }

    @Override
    public List<DentistaDTO> verDentistas() {
        List<DentistaDTO> listaDentistas = new ArrayList<>();
        List<Dentista> listaDentistasEntity = dentistaRepository.findAll();
        for (int i = 0; i < listaDentistasEntity.size(); i++) {
            listaDentistas.add(new DentistaDTO(listaDentistasEntity.get(i)));
        }

        return listaDentistas;
    }
}
