package com.imdaz.service;

import com.imdaz.model.Filhos;
import com.imdaz.repository.FilhosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return filhosRepository.findById(id).orElse(null);
    }

    public void deletarFilho(Long id) {
        filhosRepository.deleteById(id);
    }
}
