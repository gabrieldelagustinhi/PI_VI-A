package com.imdaz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Mae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

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

    @OneToMany(mappedBy = "mae")
    private List<Filhos> filhos;
}
