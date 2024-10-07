package com.imdaz.service;

import com.imdaz.model.Filhos;
import com.imdaz.repository.FilhosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class FilhosService {

    @Autowired
    private FilhosRepository filhosRepository;

    public List<Filhos> listarFilhos() {
        return filhosRepository.findAll();
    }

    public Filhos salvarFilho(Filhos filhos) {
        return filhosRepository.save(filhos);
    }

    public Filhos buscarPorId(Long id) {
        return filhosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "aluno não encontrado"));
    }

    public void deletarFilho(Long id) {
        filhosRepository.deleteById(id);
    }
}
