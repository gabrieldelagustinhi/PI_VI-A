package com.imdaz.service;

import com.imdaz.model.Filhos;
import com.imdaz.model.Mae;
import com.imdaz.repository.FilhosRepository;
import com.imdaz.repository.MaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaeService {

    @Autowired
    private MaeRepository maeRepository;

    @Autowired
    private FilhosRepository filhosRepository;

    public List<Mae> listarMaes() {
        return maeRepository.findAll();
    }

    public Mae salvarMae(Mae mae) {
        Mae novaMae = maeRepository.save(mae);

        if (mae.getFilhos() != null) {
            for (Filhos filho : mae.getFilhos()) {
                filho.setMae(novaMae);
                filhosRepository.save(filho);
            }
        }

        return novaMae;
    }

    public Mae buscarPorId(Long id) {
        return maeRepository.findById(id).orElse(null);
    }

    public void deletarMae(Long id) {
        maeRepository.deleteById(id);
    }
}
