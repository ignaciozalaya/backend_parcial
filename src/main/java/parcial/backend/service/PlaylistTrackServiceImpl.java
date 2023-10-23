package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Playlist;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistTrackServiceImpl implements PlaylistService {

    @Override
    public List<Playlist> findAll() {
        return null;
    }

    @Override
    public Optional<Playlist> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
