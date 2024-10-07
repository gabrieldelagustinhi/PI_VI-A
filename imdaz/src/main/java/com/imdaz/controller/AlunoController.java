package com.imdaz.controller;

import com.imdaz.controller.response.AlunoResponse;
import com.imdaz.model.Aluno;
import com.imdaz.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoResponse> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
