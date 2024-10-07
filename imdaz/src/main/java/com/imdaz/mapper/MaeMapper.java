package com.imdaz.mapper;

import com.imdaz.controller.response.NomeResponse;
import com.imdaz.controller.response.MaeResponse;
import com.imdaz.model.Filhos;
import com.imdaz.model.Mae;

import static java.util.stream.Collectors.toList;

public class MaeMapper {

    public static MaeResponse toResponse(Mae entity) {
        MaeResponse response = new MaeResponse();

        response.setId(entity.getId());
        response.setNome(entity.getUsuario().getNome());
        response.setQuantosFilhos(entity.getQuantosFilhos());
        response.setTrabalhaFora(entity.isTrabalhaFora());
        response.setTemComQuemDeixarFilhos(entity.isTemComQuemDeixarFilhos());
        response.setComQuemDeixarFilhos(entity.getComQuemDeixarFilhos());
        response.setQuerParticiparProjeto(entity.isQuerParticiparProjeto());
        response.setProjeto(entity.getProjeto());
        response.setCpfNotaGaucha(entity.isCpfNotaGaucha());
        response.setTipoResidencia(entity.getTipoResidencia());
        response.setNumeroPecas(entity.getNumeroPecas());
        response.setPossuiBanheiro(entity.isPossuiBanheiro());
        response.setPossuiLuz(entity.isPossuiLuz());
        response.setFilhosNome(
                entity.getFilhos().stream()
                        .map(MaeMapper::toResponseFilhos)
                        .collect(toList())
        );

        return response;
    }

    private static NomeResponse toResponseFilhos(Filhos filho) {
        NomeResponse response = new NomeResponse();

        response.setNome(filho.getUsuario().getNome());

        return response;
    }
}
