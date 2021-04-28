package com.example.consultorio.entity;

import com.example.consultorio.dto.PacienteDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Paciente {

    public Paciente(PacienteDTO pacienteDTO){
        this.name = pacienteDTO.getName();
        this.last_name = pacienteDTO.getLast_name();
        this.dni = pacienteDTO.getDni();
        this.email = pacienteDTO.getEmail();
        this.turnos = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String last_name;
    @NotNull
    private String dni;
    @NotNull
    private String email;

    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos;
}
