package com.spring_pry.Proyecto.data;

import com.spring_pry.Proyecto.dto.CursoDTO;
import com.spring_pry.Proyecto.dto.EstudianteDTO;
import lombok.Data;

@Data
public class RequestWrapper {
    private EstudianteDTO estudianteDTO;
    private CursoDTO cursoDTO;
}
