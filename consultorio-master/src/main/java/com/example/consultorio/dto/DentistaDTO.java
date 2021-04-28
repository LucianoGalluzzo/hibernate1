package com.example.consultorio.dto;

import com.example.consultorio.entity.Agenda;
import com.example.consultorio.entity.Dentista;
import com.example.consultorio.entity.Paciente;
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
public class DentistaDTO {

    private String name;

    private String last_name;

    private String dni;

    private String email;

    public DentistaDTO(Dentista dentista){
        this.dni = dentista.getDni();
        this.name = dentista.getName();
        this.email = dentista.getEmail();
        this.last_name = dentista.getLast_name();
    }
}
