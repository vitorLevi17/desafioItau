package com.br.desafio.controller;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/")
    public ResponseEntity<Void> criarTransacao(@Valid @RequestBody CriarTransacaoDTO dto){
        transacaoService.criarTransacao(dto);
        return ResponseEntity.status(201).build();
    }
}