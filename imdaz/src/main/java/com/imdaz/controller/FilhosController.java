package com.imdaz.controller;

import com.imdaz.model.Filhos;
import com.imdaz.service.FilhosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filhos")
public class FilhosController {

    @Autowired
    private FilhosService filhosService;

    @PostMapping
    public Filhos salvarFilho(@RequestBody Filhos filhos) {
        return filhosService.salvarFilho(filhos);
    }

    @DeleteMapping("/{id}")
    public void deletarFilho(@PathVariable Long id) {
        filhosService.deletarFilho(id);
    }
}