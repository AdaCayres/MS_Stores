package br.com.ada.livraria.MS_Stores.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
public class Address {
 private String cep;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private boolean erro;
}
