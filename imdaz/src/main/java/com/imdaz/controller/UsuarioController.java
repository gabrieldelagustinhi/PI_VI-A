package com.imdaz.controller;

import com.imdaz.controller.request.UsuarioRequest;
import com.imdaz.controller.response.NomeResponse;
import com.imdaz.model.Usuario;
import com.imdaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody UsuarioRequest resquest) {
        return usuarioService.salvarUsuario(resquest);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/aniversariantes")
    public List<NomeResponse> listarAniversariantes() {
        return usuarioService.buscarAniversariantes();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
