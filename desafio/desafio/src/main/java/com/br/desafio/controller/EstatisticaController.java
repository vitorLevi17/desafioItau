package com.br.desafio.controller;

import com.br.desafio.DTO.EstatisticaDTO;
import com.br.desafio.service.EstatisticaService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private EstatisticaService service;
    private static final Logger log = LoggerFactory.getLogger(EstatisticaController.class);

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> getEstatistica(){
        log.info("Requisição recebida para retornar estatisticas.");
        EstatisticaDTO estatistica = service.getEstatistica();
        log.info("Estatisticas retornadas com sucesso.");
        return ResponseEntity.ok(estatistica);
    }
}
