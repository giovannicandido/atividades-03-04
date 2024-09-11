package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private Map<String, ExternalCepRestService> externalImpl =
            Map.of(
                    "VIACEP",
                    new ViaCepRestServiceImpl(),
                    "CEPABERTO",
                    new CepAbertoServiceImpl(),
                    "BRASILAPI",
                    new BrasilApiRestServiceImpl()
            );

    @Override
    public Endereco searchByCep(String cep) {

        Endereco response = null;
        for (String api : fallbackOrder) {
            try {
                ExternalCepRestService externalService = externalImpl.get(api);
                response = externalService.searchByCep(cep);
                break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }

}
