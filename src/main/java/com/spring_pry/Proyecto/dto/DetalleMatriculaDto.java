package com.spring_pry.Proyecto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleMatriculaDto {

    private Integer idDetalleMatricula;
    @NotNull
    @JsonIncludeProperties(value = {"idCurso"})
    private CursoDTO curso;

    @JsonBackReference
    private MatriculaDTO matricula;

    private String aula;
}
