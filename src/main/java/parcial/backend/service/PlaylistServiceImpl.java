package parcial.backend.service;

import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;
import parcial.backend.repositories.IdentifierRepository;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final IdentifierRepository identifierRepository;
    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(IdentifierRepository identifierRepository,
                               PlaylistRepository playlistRepository) {
        this.identifierRepository = identifierRepository;
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        return playlistRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            playlistRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Playlist not found");
        }
    }

    @Override
    @Transactional
    public Playlist create(String name) {
        val playlistId = identifierRepository.nextValue(Playlist.TABLE_NAME);
        val playlist = new Playlist(playlistId, name);
        return playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public void update(Integer id, String name) {
        val artist = playlistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Playlist not Found"));
        artist.update(name);
        playlistRepository.save(artist);
    }
}
