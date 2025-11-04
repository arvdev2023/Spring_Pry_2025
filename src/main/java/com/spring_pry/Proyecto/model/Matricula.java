package com.spring_pry.Proyecto.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;

    private LocalDateTime fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "fk_estudiante_matricula"))
    private Estudiante estudiante;

    private boolean estado;

    @OneToMany(mappedBy = "matricula",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleMatricula> detalleMatriculaList;
}
