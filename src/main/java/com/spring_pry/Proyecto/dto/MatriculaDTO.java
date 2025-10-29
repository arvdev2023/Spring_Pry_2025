package com.spring_pry.Proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private LocalDateTime fechaMatricula;
    private EstudianteDTO estudiante;
    private List<DetalleMatriculaDto> detalle;
    private boolean estado;
}
