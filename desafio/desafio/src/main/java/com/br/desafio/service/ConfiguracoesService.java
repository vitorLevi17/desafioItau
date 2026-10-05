package com.br.desafio.service;

import com.br.desafio.model.Configuracoes;
import com.br.desafio.repository.ConfiguracoesRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracoesService {

    private ConfiguracoesRepository repository;

    public ConfiguracoesService(ConfiguracoesRepository repository) {
        this.repository = repository;
    }

    public void alterarTempoEstatistica(int segundos){
        repository.alterarTempoEstatistica(segundos);
    }
}
