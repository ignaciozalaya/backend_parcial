package parcial.backend.service;

import org.springframework.data.jpa.repository.Query;
import parcial.backend.entities.Artist;

import java.util.Optional;

public interface ArtistService extends Service<Artist, Long> {

    Optional<Artist> findByName(String Name);

}
