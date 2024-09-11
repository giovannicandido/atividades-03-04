package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.service.rest.impl.BrasilApiRestServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.CepAbertoServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.FallBackRestImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.ViaCepRestServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExternalCepFactory {

    @Value("${app.cep.api}")
    private String apiConfig;

    @Value("${app.cep.fallback:false}")
    private Boolean fallback = false;

    @Value("${app.cep.fallback-order}")
    private List<String> fallbackOrder;

    private Map<String, ExternalCepRestService> EXTERNAL_SYSTEMS;

    @PostConstruct
    public void init() {
        EXTERNAL_SYSTEMS = Map.of(
                "VIACEP",
                new ViaCepRestServiceImpl(),
                "CEPABERTO",
                new CepAbertoServiceImpl(),
                "BRASILAPI",
                new BrasilApiRestServiceImpl(),
                "FALLBACK",
                new FallBackRestImpl(fallbackOrder)
        );

        if(fallback) {
            this.apiConfig = "FALLBACK";
        }
    }

    private final Map<String, ExternalCepRestService> externalCepRestServiceMap;
//    private final List<ExternalCepRestService> externalCepSystems;

    public ExternalCepRestService create() {
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

        return Optional.ofNullable(EXTERNAL_SYSTEMS.get(apiConfig))
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

        // programador senior
        //return Optional.ofNullable(externalCepRestServiceMap.get(apiConfig))
         //       .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

    }
}
