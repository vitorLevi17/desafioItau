package com.br.desafio.controller;

import com.br.desafio.DTO.EstatisticaDTO;
import com.br.desafio.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> getEstatistica(){
        EstatisticaDTO estatistica = service.getEstatistica();
        return ResponseEntity.ok(estatistica);
    }
}
