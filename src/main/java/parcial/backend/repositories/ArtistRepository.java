package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Artist;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("SELECT a FROM Artist a WHERE a.name = ?1")
    Optional<Artist> findByName(String Name);

}