package com.imdaz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String anoEscolar;
    private String escola;
    private String turno;
    private String turma;
    private boolean temIrmaoInstituicao;
    private String nomeResponsavel;
    private String parentescoResponsavel;
}
