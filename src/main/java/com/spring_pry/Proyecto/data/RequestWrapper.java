package com.spring_pry.Proyecto.data;

import com.spring_pry.Proyecto.dto.CursoDTO;
import com.spring_pry.Proyecto.dto.EstudianteDTO;
import com.spring_pry.Proyecto.dto.MatriculaDTO;
import lombok.Data;

@Data
public class RequestWrapper {
    private EstudianteDTO estudianteDTO;
    private CursoDTO cursoDTO;
    private MatriculaDTO matriculaDTO;
}
