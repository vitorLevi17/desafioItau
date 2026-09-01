package com.br.desafio.controller;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/")
    public ResponseEntity<List<Transacao>> listarTransacoes(){
        var lista = transacaoService.transacaoLista();
        return ResponseEntity.status(200).body(lista);
    }
}