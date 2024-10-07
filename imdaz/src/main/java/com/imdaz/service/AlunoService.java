package com.imdaz.service;

import com.imdaz.controller.response.AlunoResponse;
import com.imdaz.mapper.AlunoMapper;
import com.imdaz.model.Aluno;
import com.imdaz.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponse> listarAlunos() {
        return alunoRepository.findAll().stream()
                .map(AlunoMapper::toResponse)
                .collect((toList()));
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "aluno não encontrado"));

        return AlunoMapper.toResponse(aluno);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
