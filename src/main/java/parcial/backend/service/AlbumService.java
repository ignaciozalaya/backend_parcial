package parcial.backend.service;

import parcial.backend.entities.Album;

import java.util.List;

public interface AlbumService extends Service<Album, Integer> {
    Album create(String title, String artistName);
    void update(Integer id, String title, String artistName);

}
