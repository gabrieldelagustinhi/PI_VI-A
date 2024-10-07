package com.imdaz.mapper;

import com.imdaz.controller.request.UsuarioRequest;
import com.imdaz.controller.response.NomeResponse;
import com.imdaz.model.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();

        entity.setNome(request.getNome());
        entity.setGenero(request.getGenero());
        entity.setEtnia(request.getEtnia());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setDeficiencia(request.isDeficiencia());
        entity.setTelefone(request.getTelefone());
        entity.setAlfabetizado(request.isAlfabetizado());
        entity.setRg(request.getRg());
        entity.setDataEmissaoRg(request.getDataEmissaoRg());
        entity.setCpf(request.getCpf());
        entity.setBairro(request.getBairro());
        entity.setEndereco(request.getEndereco());
        entity.setRendaFamiliarMensal(request.getRendaFamiliarMensal());
        entity.setRecebeBolsaFamilia(request.isRecebeBolsaFamilia());
        entity.setNis(request.getNis());
        entity.setDireitoImagem(request.isDireitoImagem());

        return entity;
    }

    public static NomeResponse toResponseNome(Usuario usuario) {
        NomeResponse response = new NomeResponse();

        response.setNome(usuario.getNome());

        return response;
    }
}
