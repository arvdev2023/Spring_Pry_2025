package com.spring_pry.Proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String siglas;

    @NotNull
    private boolean estado;
}
