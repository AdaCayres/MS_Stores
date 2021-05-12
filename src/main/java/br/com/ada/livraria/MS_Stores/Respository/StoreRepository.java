package br.com.ada.livraria.MS_Stores.Respository;

import br.com.ada.livraria.MS_Stores.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
