package com.example.consultorio.entity;


import com.example.consultorio.dto.DentistaDTO;
import com.example.consultorio.dto.PacienteDTO;
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
public class Dentista {

    public Dentista(DentistaDTO dentistaDTO){
        this.name = dentistaDTO.getName();
        this.last_name = dentistaDTO.getLast_name();
        this.dni = dentistaDTO.getDni();
        this.email = dentistaDTO.getEmail();
        this.agendas = new ArrayList<Agenda>();
    }
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String name;

    private String last_name;

    private String dni;

    private String email;

    @OneToMany(mappedBy = "dentista")
    private List<Agenda> agendas;
}
