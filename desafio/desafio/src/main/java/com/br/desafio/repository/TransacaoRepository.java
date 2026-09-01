package com.br.desafio.repository;

import com.br.desafio.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TransacaoRepository {

    private List<Transacao> transacaoLista = Collections.synchronizedList(new ArrayList<>());;

    public void salvarTransacao(Transacao transacao) {
        this.transacaoLista.add(transacao);
    }
    public List<Transacao> getTransacaoLista() {
        return transacaoLista;
    }
}
