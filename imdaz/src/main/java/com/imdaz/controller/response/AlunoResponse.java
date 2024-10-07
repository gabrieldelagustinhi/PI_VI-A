package com.imdaz.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoResponse {

    private Long id;
    private String nome;
    private String anoEscolar;
    private String escola;
    private String turno;
    private String turma;
    private boolean temIrmaoInstituicao;
    private String nomeResponsavel;
    private String parentescoResponsavel;
}
