package parcial.backend.service;

import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;
import parcial.backend.repositories.IdentifierRepository;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final IdentifierRepository identifierRepository;
    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;

    public PlaylistServiceImpl(IdentifierRepository identifierRepository,
                               PlaylistRepository playlistRepository,
                               TrackRepository trackRepository) {
        this.identifierRepository = identifierRepository;
        this.playlistRepository = playlistRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
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

    @Override
    public List<Playlist> findAllByTracksTrackId(Integer trackId) {
        val playlist = playlistRepository.findAllByTracksTrackId(trackId);
        return playlist;
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        return playlistRepository.findById(id);
    }

    @Override
    @Transactional
    public Playlist addTrackToPlaylist(Integer playlistId, Integer trackId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new IllegalArgumentException("Playlist not found"));

        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new IllegalArgumentException("Track not found"));

        // Añadir el track a la lista de tracks de la playlist
        List<Track> tracks = playlist.getTracks();
        if (!tracks.contains(track)) {
            tracks.add(track);
            playlist.setTracks(tracks);
            return playlistRepository.save(playlist);
        }

        return playlist; // La playlist ya contiene el track
    }

}
