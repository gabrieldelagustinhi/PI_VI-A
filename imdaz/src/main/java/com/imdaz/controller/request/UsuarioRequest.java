package com.imdaz.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String genero;

    @NotBlank
    private String etnia;

    @NotNull
    private LocalDate dataNascimento;

    private boolean deficiencia;

    @NotBlank
    private String telefone;

    private boolean alfabetizado;

    @NotBlank
    private String rg;

    @NotNull
    private LocalDate dataEmissaoRg;

    @NotBlank
    private String cpf;

    @NotBlank
    private String bairro;

    @NotBlank
    private String endereco;

    @NotNull
    private double rendaFamiliarMensal;

    private boolean recebeBolsaFamilia;
    private String nis;
    private boolean direitoImagem;
}
