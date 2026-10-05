package com.br.desafio.repository;

import com.br.desafio.model.Configuracoes;
import org.springframework.stereotype.Repository;

@Repository
public class ConfiguracoesRepository {

    private Configuracoes configuracoes;

    public ConfiguracoesRepository() {
        this.configuracoes = new Configuracoes();
        this.configuracoes.setSegundosEstatistica(60);
    }

    public void alterarTempoEstatistica(int segundos){
        configuracoes.setSegundosEstatistica(segundos);
    }
    public Integer getSegundosEstatistica(){
        return this.configuracoes.getSegundosEstatistica();
    }
}