package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Artist;
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}