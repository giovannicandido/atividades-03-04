package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;

public class BrasilApiRestServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        return Endereco.builder()
                .logradouro("Brasil api")
                .cep(cep)
                .build();
    }
}
