package br.org.fundatec.lpIII.atividades.service;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepFactory;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepService {
    private final ExternalCepFactory externalCepFactory;



    private final ExternalCepRestService externalCepRestService;


    public Endereco searchEndereco(String cep) {
        return externalCepFactory.create()
                .searchByCep(cep);
        //return externalCepRestService.searchByCep(cep);
    }

}
