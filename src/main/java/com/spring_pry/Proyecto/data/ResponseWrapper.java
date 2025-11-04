package com.spring_pry.Proyecto.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring_pry.Proyecto.model.Curso;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.model.Matricula;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseWrapper {
    private Estudiante estudiante;
    private List<Estudiante> estudianteList;

    private Curso curso;
    private List<Curso> cursoList;

    private Matricula matricula;
    private List<Matricula> matriculaList;
}
