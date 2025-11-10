package com.spring_pry.Proyecto.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private Integer idMatricula;

    private LocalDateTime fechaMatricula;
    @NotNull
    @JsonIncludeProperties(value = {"idEstudiante"})
    private EstudianteDTO estudiante;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDto> detalleMatriculaList;

    @NotNull
    private boolean estado;
}
