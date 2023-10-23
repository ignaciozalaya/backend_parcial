package parcial.backend.service;

import org.springframework.data.jpa.repository.Query;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;

import java.util.Optional;

public interface ArtistService extends Service<Artist, Integer> {

    Optional<Artist> findByName(String Name);

    Artist create(String name);
    void update(Integer id, String name);

}
