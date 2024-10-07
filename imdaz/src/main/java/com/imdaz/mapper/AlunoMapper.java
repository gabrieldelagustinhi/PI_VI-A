package com.imdaz.mapper;

import com.imdaz.controller.response.AlunoResponse;
import com.imdaz.model.Aluno;

public class AlunoMapper {
    public static AlunoResponse toResponse(Aluno entity) {
        AlunoResponse response = new AlunoResponse();

        response.setId(entity.getId());
        response.setNome(entity.getUsuario().getNome());
        response.setAnoEscolar(entity.getAnoEscolar());
        response.setEscola(entity.getEscola());
        response.setTurno(entity.getTurno());
        response.setTurma(entity.getTurma());
        response.setTemIrmaoInstituicao(entity.isTemIrmaoInstituicao());
        response.setNomeResponsavel(entity.getNomeResponsavel());
        response.setParentescoResponsavel(entity.getParentescoResponsavel());

        return response;
    }
}
