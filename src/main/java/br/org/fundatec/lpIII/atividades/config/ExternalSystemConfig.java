package br.org.fundatec.lpIII.atividades.config;

import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import br.org.fundatec.lpIII.atividades.service.rest.impl.BrasilApiRestServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.CepAbertoServiceImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.FallBackRestImpl;
import br.org.fundatec.lpIII.atividades.service.rest.impl.ViaCepRestServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class ExternalSystemConfig {
    @Value("${app.cep.api}")
    private String apiConfig;

    @Value("${app.cep.fallback-order}")
    private List<String> falbackOrder;

    @Bean
    public Map<String, ExternalCepRestService> externalSystemBean() {
        return Map.of(
                "VIACEP",
                new ViaCepRestServiceImpl(),
                "CEPABERTO",
                new CepAbertoServiceImpl(),
                "BRASILAPI",
                new BrasilApiRestServiceImpl()
        );
    }

    @Bean
    @ConditionalOnProperty(value = "app.cep.fallback", havingValue = "false" )
    public ExternalCepRestService externalCepRestService() {
        return externalSystemBean().get(apiConfig);
    }

    @Bean
    @ConditionalOnProperty(value = "app.cep.fallback", havingValue = "true" )
    public ExternalCepRestService externalCepRestServiceFallback() {
        return new FallBackRestImpl(this.falbackOrder);
    }
}
