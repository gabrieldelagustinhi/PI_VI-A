package com.imdaz.service;

import com.imdaz.controller.response.MaeResponse;
import com.imdaz.mapper.MaeMapper;
import com.imdaz.model.Filhos;
import com.imdaz.model.Mae;
import com.imdaz.repository.FilhosRepository;
import com.imdaz.repository.MaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class MaeService {

    @Autowired
    private MaeRepository maeRepository;

    @Autowired
    private FilhosRepository filhosRepository;

    public List<MaeResponse> listarMaes() {
        return maeRepository.findAll().stream()
                .map(MaeMapper::toResponse)
                .collect(toList());
    }

    public MaeResponse salvarMae(Mae mae) {
        Mae novaMae = maeRepository.save(mae);

        if (mae.getFilhos() != null) {
            for (Filhos filho : mae.getFilhos()) {
                filho.setMae(novaMae);
                filhosRepository.save(filho);
            }
        }

        return MaeMapper.toResponse(novaMae);
    }

    public MaeResponse buscarPorId(Long id) {
        Mae mae = maeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "mae não encontrado"));
        return MaeMapper.toResponse(mae);
    }

    public void deletarMae(Long id) {
        maeRepository.deleteById(id);
    }
}
