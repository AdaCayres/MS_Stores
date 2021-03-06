package br.com.ada.livraria.MS_Stores.Service;

import br.com.ada.livraria.MS_Stores.Exception.StoreNotFoundException;
import br.com.ada.livraria.MS_Stores.Exception.WrongAddressException;
import br.com.ada.livraria.MS_Stores.Model.Address;
import br.com.ada.livraria.MS_Stores.Model.Store;
import br.com.ada.livraria.MS_Stores.Respository.AddressRepository;
import br.com.ada.livraria.MS_Stores.Respository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StoreService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StoreRepository storeRepository;

    public Store addNew(Store store) {
        try {
            Address address = addressRepository.getToAddress(store.getCEP());
            if (address.isErro()) throw new WrongAddressException("CEP errado");
            return (Store) storeRepository.save(store);
        }catch(ClientErrorException e){
            throw new WrongAddressException("CEP errado");
        }
    }


    public List<Store> listALL() {
        log.info("["+ System.nanoTime() + "] Exhibiting all ids  in the DB.");
        return storeRepository.findAll();
    }

    public Store getById(long id){
        Optional<Store> store = storeRepository.findById(id);
        if(!store.isPresent()) throw new StoreNotFoundException("id- " + id);
        return store.get();
    }

    public ResponseEntity<Object> updateById(Store store, long id){
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(!storeOptional.isPresent()) return ResponseEntity.notFound().build();
        store.setId(id);
        storeRepository.save(store);
        log.info("["+ System.nanoTime() +"] User modified the store with id " + id + " in the DB.");
        return ResponseEntity.noContent().build();
    }


    public void deleteById(long id){
        Optional<Store> store = storeRepository.findById(id);
        storeRepository.deleteById(id);
        if(store.isEmpty()) throw new StoreNotFoundException("");
        log.info("["+ System.nanoTime() +"] User deleted the store with id " + id + " in the DB.");
    }

}