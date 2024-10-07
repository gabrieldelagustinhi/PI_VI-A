package com.imdaz.controller;

import com.imdaz.model.Mae;
import com.imdaz.service.MaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/maes")
public class MaeController {

    @Autowired
    private MaeService maeService;

    @GetMapping
    public List<Mae> listarMaes() {
        return maeService.listarMaes();
    }

    @PostMapping
    public Mae salvarMae(@RequestBody Mae mae) {
        return maeService.salvarMae(mae);
    }

    @GetMapping("/{id}")
    public Mae buscarMaePorId(@PathVariable Long id) {
        return maeService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarMae(@PathVariable Long id) {
        maeService.deletarMae(id);
    }
}
