package com.example.consultorio.dto;

import com.example.consultorio.entity.Paciente;
import com.example.consultorio.entity.Turno;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private String name;
    private String last_name;
    private String dni;
    private String email;

    public PacienteDTO(Paciente paciente){
        this.dni = paciente.getDni();
        this.name = paciente.getName();
        this.email = paciente.getEmail();
        this.last_name = paciente.getLast_name();
    }

}
