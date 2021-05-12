package br.com.ada.livraria.MS_Stores.Respository;

import br.com.ada.livraria.MS_Stores.Model.Address;
import org.springframework.stereotype.Repository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Repository
public class AddressRepository {


    Client client;
    WebTarget target;

    public Address getToAddress(String cep){
        client = ClientBuilder.newClient();
        target = client.target("http://viacep.com.br/ws/" + cep + "/json/");
        return target.request(MediaType.APPLICATION_JSON).get(Address.class);

    }
}
