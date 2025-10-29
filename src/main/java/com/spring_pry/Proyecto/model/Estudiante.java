package com.spring_pry.Proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Access(AccessType.FIELD)
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    @Column(length = 100)
    private String nombres;

    @Column(length = 200)
    private String apellidos;

    @Column(length = 50,name = "DNI")
    private String DNI;

    private Integer edad;
}
