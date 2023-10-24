package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.PlaylistDto;
import parcial.backend.entities.dtos.TrackDto;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.service.PlaylistService;
import parcial.backend.service.TrackService;
import parcial.backend.service.mappers.PlaylistDtoMapper;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final TrackService trackService;
    private final PlaylistDtoMapper playlistDtoMapper;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackService trackService, PlaylistDtoMapper playlistDtoMapper) {
        this.playlistRepository = playlistRepository;
        this.trackService = trackService;
        this.playlistDtoMapper = playlistDtoMapper;
    }

    @Override
    public void add(PlaylistDto entity) {
        Playlist playlist = new Playlist();
        playlist.setName(entity.getName());
        this.playlistRepository.save(playlist);
    }

    @Override
    public void update(PlaylistDto entity) {
        Optional<Playlist> optionalPlaylistDto = this.playlistRepository.findById(entity.getPlaylistId());
        optionalPlaylistDto.ifPresent(this.playlistRepository::save);
    }

    @Override
    public PlaylistDto delete(Long aLong) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(aLong);
        playlistOptional.ifPresent(this.playlistRepository::delete);
        return playlistOptional
                .map(playlistDtoMapper).orElseThrow();
    }

    @Override
    public PlaylistDto getById(Long aLong) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(aLong);
        return playlistOptional
                .map(playlistDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<PlaylistDto> getAll() {
        List<Playlist> playlists = this.playlistRepository.findAll();
        return playlists
                .stream()
                .map(playlistDtoMapper)
                .toList();
    }
    @Override
    public PlaylistDto addTrackToPlaylist(Long idPlaylist, Long idTrack) {
        if (idPlaylist == null || idTrack == null) {
            throw new RuntimeException("Id playlist and id track are required");
        }
        Track track = trackService.getByIdTrack(idTrack);

        Playlist playlist = playlistRepository.getById(idPlaylist);

        if (playlist.getTracks().contains(track)) {
            throw new RuntimeException("Track already exists in playlist");
        }
        playlist.addTrack(track);
        return playlistDtoMapper.apply(playlistRepository.save(playlist));
    }
}
