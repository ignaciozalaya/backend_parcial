package parcial.backend.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.backend.entities.Artist;
import parcial.backend.entities.PlaylistTrack;
import parcial.backend.entities.PlaylistTrackId;
import parcial.backend.repositories.PlaylistTrackRepository;
import parcial.backend.service.PlaylistTrackService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistTrackServiceImpl implements PlaylistTrackService {
 private final PlaylistTrackRepository playlistTrackRepository;

@Autowired
    public PlaylistTrackServiceImpl(PlaylistTrackRepository playlistTrackRepository) {
        this.playlistTrackRepository = playlistTrackRepository;
    }

//    public PlaylistTrack getPlaylistTrackByPlaylistAndTrack(Long playlistId, Long trackId) {
//        return playlistTrackRepository.findByPlaylistIdAndTrackId(playlistId, trackId);
//    }

    @Override
    public void add(PlaylistTrack entity) {
        this.playlistTrackRepository.save(entity);
    }

    @Override
    public void update(PlaylistTrack entity) {
        this.playlistTrackRepository.save(entity);
    }

    @Override
    public PlaylistTrack delete(Long aLong) {
        return null;
    }

    @Override
    public PlaylistTrack getById(Long aLong) {
        return null;
    }

//    public PlaylistTrack getById(Long playlistId, Long trackId) {
//        // Crea una instancia de PlaylistTrackId con los IDs proporcionados
//        PlaylistTrackId playlistTrackId = new PlaylistTrackId(playlistId, trackId);
//
//        // Utiliza el método personalizado definido en el repositorio para buscar el PlaylistTrack
//        return playlistTrackRepository.findById(playlistTrackId)
//                .orElseThrow(() -> new EntityNotFoundException("PlaylistTrack not found"));
//    }


    @Override
    public List<PlaylistTrack> getAll() {
        List<PlaylistTrack> playlistTracks = this.playlistTrackRepository.findAll();
        return playlistTracks.stream().toList();
    }

    @Override
    public PlaylistTrack getPlaylistTrackById(Long playlistId, Long trackId) {
        return null;
    }

//    @Override
//    public PlaylistTrack getPlaylistTrackById(Long playlistId, Long trackId) {
//        return playlistTrackRepository.findByPlaylistIdAndTrackId(playlistId, trackId);
//    }
}
