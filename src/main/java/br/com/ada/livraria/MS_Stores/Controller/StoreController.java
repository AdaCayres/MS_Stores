package br.com.ada.livraria.MS_Stores.Controller;

import br.com.ada.livraria.MS_Stores.Model.Store;
import br.com.ada.livraria.MS_Stores.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public List<Store> showAllStoress(){
        return storeService.listALL();
    }

    @GetMapping("/{id}")
    public Store showStore(@PathVariable long id){
        return storeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store addStore(@RequestBody Store store){
        return storeService.addNew(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStore(@RequestBody Store store, @PathVariable long id){
        return storeService.updateById(store, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable long id){
        storeService.deleteById(id);
    }
}
