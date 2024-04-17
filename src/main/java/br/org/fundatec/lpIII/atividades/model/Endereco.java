package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
}
