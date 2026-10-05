package com.br.desafio.controller;

import com.br.desafio.DTO.ConfiguracoesDTO;
import com.br.desafio.service.ConfiguracoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracoesController {

    private ConfiguracoesService service;

    public ConfiguracoesController(ConfiguracoesService service) {
        this.service = service;
    }



    @PostMapping("alterar-tempo-estatistica")
    public ResponseEntity<ConfiguracoesDTO> alterarTempoEstatistica(@Valid @RequestBody ConfiguracoesDTO dto){
        service.alterarTempoEstatistica(dto.segundosEstatistica());
        return ResponseEntity.ok().build();
    }
}