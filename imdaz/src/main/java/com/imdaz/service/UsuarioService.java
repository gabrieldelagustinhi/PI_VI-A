package com.imdaz.service;

import com.imdaz.controller.request.UsuarioRequest;
import com.imdaz.controller.response.NomeResponse;
import com.imdaz.mapper.UsuarioMapper;
import com.imdaz.model.Usuario;
import com.imdaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(UsuarioRequest request) {

        Usuario usuario = UsuarioMapper.toEntity(request);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<NomeResponse> buscarAniversariantes() {
        LocalDate hoje = LocalDate.now();
        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();

        return usuarioRepository.findByDiaAndMesAniversario(dia, mes).stream()
                .map(UsuarioMapper::toResponseNome)
                .collect(toList());
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Usuario não encontrado"));
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
