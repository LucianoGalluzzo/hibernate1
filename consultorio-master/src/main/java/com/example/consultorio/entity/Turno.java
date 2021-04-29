package com.example.consultorio.entity;


import com.example.consultorio.dto.ReservaDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Turno {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Paciente paciente;
    @NotNull
    @ManyToOne
    private Agenda agenda;
    @NotNull
    private LocalTime start_time;
    @NotNull
    private LocalTime ending_time;
    @NotNull
    private String status;

    private Integer rescheduleTurnId;

    public Turno (ReservaDTO reserva){
        this.start_time = reserva.getStart_time();
        this.ending_time = reserva.getStart_time().plusMinutes(30);
        this.status = "Pendiente";
    }
}
