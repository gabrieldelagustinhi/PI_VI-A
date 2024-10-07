package com.imdaz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String genero;
    private String etnia;
    private LocalDate dataNascimento;
    private boolean deficiencia;
    private String telefone;
    private boolean alfabetizado;
    private String rg;
    private LocalDate dataEmissaoRg;
    private String cpf;
    private String bairro;
    private String endereco;
    private double rendaFamiliarMensal;
    private boolean recebeBolsaFamilia;
    private String nis;
    private boolean direitoImagem;
}
