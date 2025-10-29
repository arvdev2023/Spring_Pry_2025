package com.spring_pry.Proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Integer idCurso;
    private String nombre;
    private String sigla;
    private boolean estado;
}
