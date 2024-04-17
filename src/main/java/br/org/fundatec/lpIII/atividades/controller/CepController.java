package br.org.fundatec.lpIII.atividades.controller;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cep")
@RequiredArgsConstructor
public class CepController {
    private final CepService cepService;
    @GetMapping
    public Endereco getEnderecoByCep(@RequestParam("cep") String cep) {
        return cepService.searchEndereco(cep);
    }
}
