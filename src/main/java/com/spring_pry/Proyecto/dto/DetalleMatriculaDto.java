package com.spring_pry.Proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleMatriculaDto {
    private CursoDTO curso;
    private String aula;
}
