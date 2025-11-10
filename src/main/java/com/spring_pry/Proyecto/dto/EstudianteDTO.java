package com.spring_pry.Proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    private Integer idEstudiante;

    @NotNull
    @NotBlank
    @Size(min = 1,max = 100)
    private String nombres;

    @NotNull
    @NotBlank
    @Size(min = 1,max = 200)
    private String apellidos;

    @NotNull
    @NotBlank
    @Size(min = 1,max = 50)
    private String DNI;

    @NotNull
    @Min(value = 15)
    @Max(value = 65)
    private Integer edad;
}
