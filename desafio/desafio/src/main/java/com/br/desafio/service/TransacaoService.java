package com.br.desafio.service;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;
    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
    public void criarTransacao(CriarTransacaoDTO dto){
        Transacao transacao = new Transacao(dto);
        transacaoRepository.salvarTransacao(transacao);
        log.info("Serviço de criar uma transação executado com sucesso.");
    }
    public List<Transacao> transacaoLista(){
        var lista = transacaoRepository.getTransacaoLista();
        log.info("Serviço de trazer todas transações executado com sucesso.");
        return lista;
    }
    public void zerarTransacaoLista(){
        transacaoRepository.zerarTransacaoLista();
        log.info("Serviço de zerar transações executado com sucesso.");
    }
}