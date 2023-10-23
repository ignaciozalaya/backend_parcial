package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void add(Playlist entity) {
        this.playlistRepository.save(entity);
    }

    @Override
    public void update(Playlist entity) {
        this.playlistRepository.save(entity);
    }

    @Override
    public Playlist delete(Long aLong) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(aLong);
        playlistOptional.ifPresent(this.playlistRepository::delete);
        return playlistOptional.orElseThrow();
    }

    @Override
    public Playlist getById(Long aLong) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(aLong);
        return playlistOptional.
                orElseThrow();
    }

    @Override
    public List<Playlist> getAll() {
        List<Playlist> playlists = this.playlistRepository.findAll();
        return playlists.stream().toList();
    }
}
