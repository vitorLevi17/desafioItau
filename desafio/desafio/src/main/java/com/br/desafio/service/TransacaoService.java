package com.br.desafio.service;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
    public void criarTransacao(CriarTransacaoDTO dto){
        Transacao transacao = new Transacao(dto);
        transacaoRepository.salvarTransacao(transacao);
    }
    public List<Transacao> transacaoLista(){
        var lista = transacaoRepository.getTransacaoLista();
        return lista;
    }
}