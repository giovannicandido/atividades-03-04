package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        log.error("Probrema");
        throw new RuntimeException("Probrema");
//        return Endereco.builder()
//                .logradouro("Cep Aberto")
//                .cep(cep)
//                .build();
    }
}
