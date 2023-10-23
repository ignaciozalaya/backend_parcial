package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.service.PlaylistService;
import parcial.backend.service.TrackService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final TrackService trackService;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackService trackService) {
        this.playlistRepository = playlistRepository;
        this.trackService = trackService;
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
    @Override
    public Playlist addTrackToPlaylist(Long idPlaylist, Long idTrack) {
        TrackDto trackDto = trackService.getById(idTrack);

        Track track = new Track();
        track.setName(trackDto.getName());
        track.setAlbum(trackDto.getAlbum());

        Playlist playlist = playlistRepository.getById(idPlaylist);
        return  playlist.addTrack(track);
    }
}
