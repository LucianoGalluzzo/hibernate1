package com.example.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Integer codigo;
    private String message;

}
