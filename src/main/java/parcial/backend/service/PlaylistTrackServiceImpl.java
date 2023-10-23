package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.PlaylistTrack;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistTrackServiceImpl implements PlaylistTrackService {

    @Override
    public List<Integer> findAll() {
        return null;
    }

    @Override
    public Optional<Integer> findById(PlaylistTrack playlistTrack) {
        return Optional.empty();
    }

    @Override
    public void delete(PlaylistTrack playlistTrack) {

    }
}
