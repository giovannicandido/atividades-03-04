package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.model.Endereco;

public interface ExternalCepRestService {
    Endereco searchByCep(String cep);
}
