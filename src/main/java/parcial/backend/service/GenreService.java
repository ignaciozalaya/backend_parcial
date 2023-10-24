package parcial.backend.service;

import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Genre;

import java.util.Optional;

public interface GenreService extends Service<Genre, Long>{
    Optional<Genre> findByName(String Name);
}
