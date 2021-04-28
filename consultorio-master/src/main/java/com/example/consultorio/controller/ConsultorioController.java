package com.example.consultorio.controller;


import com.example.consultorio.dto.DentistaDTO;
import com.example.consultorio.dto.PacienteDTO;
import com.example.consultorio.dto.ReservaDTO;
import com.example.consultorio.dto.ResponseDTO;
import com.example.consultorio.services.ConsultorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }


    @PostMapping("/reserva")
    public ResponseDTO reservar(@RequestBody ReservaDTO reserva){

        return consultorioService.reservar(reserva);
    }

    @PostMapping("/crearPaciente")
    public ResponseEntity<String> crearPaciente(@RequestBody PacienteDTO paciente){
        consultorioService.crearPaciente(paciente);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @PostMapping("/crearDentista")
    public ResponseEntity<String> crearDentista(@RequestBody DentistaDTO dentista){
        consultorioService.crearDentista(dentista);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @GetMapping("/verPacientes")
    public ResponseEntity<List<PacienteDTO>> verPacientes(){
        return new ResponseEntity<>(consultorioService.verPacientes(), HttpStatus.OK);
    }

    @GetMapping("/verDentistas")
    public ResponseEntity<List<DentistaDTO>> verDentistas(){
        return new ResponseEntity<>(consultorioService.verDentistas(), HttpStatus.OK);
    }
}
