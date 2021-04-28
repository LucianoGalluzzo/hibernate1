package com.example.consultorio.dto;

import com.example.consultorio.entity.Paciente;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
@Data
public class ReservaDTO {

    private PacienteDTO paciente;
    private Integer id_dentista;
    private LocalDate dia;
    private Integer hora;
    private Integer minutos;


}
