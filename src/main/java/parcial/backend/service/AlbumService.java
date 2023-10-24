package parcial.backend.service;

import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;

import java.util.List;
import java.util.Optional;

public interface AlbumService extends Service<Album, Integer> {
    Album create(String title, String artistName);
    void update(Integer id, String title, String artistName);

    Optional<Album> findByName(String Name);
}
