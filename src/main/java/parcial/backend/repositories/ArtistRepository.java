package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Artist;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    @Query("SELECT a FROM Artist a WHERE a.name = ?1")
    Optional<Artist> findByName(String Name);

    //OTROS EJEMPLOS
//    @Query("SELECT s FROM Store s WHERE s.address.city.id = ?1")
//    Optional<Store> findByCityId(Integer cityId);
//
//    @Query("SELECT s FROM Store s WHERE s.address.city.id = (SELECT c.address.city.id FROM Customer c WHERE c.id = ?1)")
//    List<Store> findCustomerLocalStores(Integer customerId);
//
//    @Query("SELECT s FROM Store s LEFT JOIN FETCH s.inventories i WHERE i.film.id = ?2 AND s.address.city.id = (SELECT c.address.city.id FROM Customer c WHERE c.id = ?1) ")
//    List<Store> findCustomerLocalStoresWithFilm(Integer customerId, Integer filmId);
//

}