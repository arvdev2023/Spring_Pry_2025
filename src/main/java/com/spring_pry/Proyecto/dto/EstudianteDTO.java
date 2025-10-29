package com.spring_pry.Proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    private Integer idEstudiante;
    private String nombre;
    private String apellidos;
    private String DNI;
    private Integer edad;
}
