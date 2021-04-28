package com.example.consultorio.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Agenda {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_dentista", referencedColumnName = "id")
    private Dentista dentista;

    private LocalDateTime start_time;

    private LocalDateTime ending_time;

    private LocalDate date;

    @OneToMany(mappedBy = "agenda")
    private List<Turno> turnos;


}
