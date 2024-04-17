package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.service.rest.impl.BrasilApiRestServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.CepAbertoServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.ViaCepRestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExternalCepFactory {
    private static final Map<String, ExternalCepRestService> EXTERNAL_SYSTEMS = Map.of(
            "VIACEP",
            new ViaCepRestServiceImpl(),
            "CEPABERTO",
            new CepAbertoServiceImpl(),
            "BRASILAPI",
            new BrasilApiRestServiceImpl()
    );

    private final Map<String, ExternalCepRestService> externalCepRestServiceMap;
//    private final List<ExternalCepRestService> externalCepSystems;

    public ExternalCepRestService create(String api) {
        // programador junior
//        if("VIACEP".equals(api)) {
//            return new ViaCepRestServiceImpl();
//        }else if("CEPABERTO".equals(api)) {
//            return new CepAbertoServiceImpl();
//        } else if("BRASILAPI".equals(api)) {
//            return new BrasilApiRestServiceImpl();
//        } else {
//            throw new RuntimeException("Não foi possivel encontrar uma implementação de cep");
//        }
        // programador pleno

//        return Optional.ofNullable(EXTERNAL_SYSTEMS.get(api))
//                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));
//
        // programador senior
        return Optional.ofNullable(externalCepRestServiceMap.get(api))
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

    }
}
