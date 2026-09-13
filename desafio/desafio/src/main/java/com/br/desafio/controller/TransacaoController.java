package com.br.desafio.controller;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.service.TransacaoService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    private static final Logger log = (Logger) LoggerFactory.getLogger(TransacaoController.class);
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/")
    public ResponseEntity<Void> criarTransacao(@Valid @RequestBody CriarTransacaoDTO dto){
        log.info("INFO: Requisição recebida para criar transação.");
        transacaoService.criarTransacao(dto);
        log.info("INFO: Transação processada. Retornando 201 Created.");
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/")
    public ResponseEntity<List<Transacao>> listarTransacoes(){
        log.info("INFO: Requisição recebida para listar transações.");
        var lista = transacaoService.transacaoLista();
        log.info("Transações listadas com sucesso. Retornando 200 OK.");
        return ResponseEntity.status(200).body(lista);
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> deletarTransacao(){
        log.info("INFO: Requisição recebida para criar transação.");
        transacaoService.zerarTransacaoLista();
        log.info("Transações apagadas com sucesso. Retornando 200 OK.");
        return ResponseEntity.status(200).build();
    }
}