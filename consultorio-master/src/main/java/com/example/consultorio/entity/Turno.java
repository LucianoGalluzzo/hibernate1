package com.example.consultorio.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime start_time;
    @NotNull
    private LocalDateTime ending_time;
    @NotNull
    private boolean status;
}
