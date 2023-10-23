package parcial.backend.service;

import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;

public interface PlaylistService extends Service<Playlist, Integer> {

    Playlist create(String name);
    void update(Integer id, String name);
}
