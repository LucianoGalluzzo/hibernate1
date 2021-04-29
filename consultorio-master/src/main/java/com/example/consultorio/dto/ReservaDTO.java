package com.example.consultorio.dto;

import com.example.consultorio.entity.Paciente;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReservaDTO {

    private PacienteDTO paciente;
    private Integer id_dentista;
    private LocalDate dia;
    private LocalTime start_time;


}
