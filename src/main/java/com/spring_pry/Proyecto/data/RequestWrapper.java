package com.spring_pry.Proyecto.data;

import com.spring_pry.Proyecto.dto.CursoDTO;
import com.spring_pry.Proyecto.dto.EstudianteDTO;
import com.spring_pry.Proyecto.dto.MatriculaDTO;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class RequestWrapper {
    @Valid
    private EstudianteDTO estudianteDTO;

    @Valid
    private CursoDTO cursoDTO;

    @Valid
    private MatriculaDTO matriculaDTO;
}
