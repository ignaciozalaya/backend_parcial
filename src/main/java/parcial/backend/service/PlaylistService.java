package parcial.backend.service;

import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService extends Service<Playlist, Integer> {

    Playlist create(String name);
    void update(Integer id, String name);
    List<Playlist> findAllByTracksTrackId(Integer trackId);


}
