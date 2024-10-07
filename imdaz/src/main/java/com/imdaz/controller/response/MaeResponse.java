package com.imdaz.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MaeResponse {

    private Long id;
    private String nome;
    private int quantosFilhos;
    private boolean trabalhaFora;
    private boolean temComQuemDeixarFilhos;
    private String comQuemDeixarFilhos;
    private boolean querParticiparProjeto;
    private String projeto;
    private boolean cpfNotaGaucha;
    private String tipoResidencia;
    private int numeroPecas;
    private boolean possuiBanheiro;
    private boolean possuiLuz;
    private List<NomeResponse> filhosNome;
}
