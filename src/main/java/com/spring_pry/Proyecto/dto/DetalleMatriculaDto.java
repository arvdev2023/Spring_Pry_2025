package com.spring_pry.Proyecto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    private String aula;
}
