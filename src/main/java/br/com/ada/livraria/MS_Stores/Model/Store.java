package br.com.ada.livraria.MS_Stores.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "companyName", length = 40)
    private String CompanyName;
    @Column(name = "tradingName", length = 40)
    private String TradingName;
    @Column(name = "cnpj", length = 40)
    private String CNPJ;
    @Column(name = "cep", length = 20)
    private String CEP;
}
