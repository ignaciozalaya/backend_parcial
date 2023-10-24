package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.AlbumService;
import parcial.backend.service.TrackService;
import parcial.backend.service.mappers.TrackDtoMapper;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final AlbumService albumService;
    private final TrackDtoMapper trackDtoMapper;
    public TrackServiceImpl(TrackRepository trackRepository, AlbumService albumService, TrackDtoMapper trackDtoMapper) {
        this.trackRepository = trackRepository;
        this.albumService = albumService;
        this.trackDtoMapper = trackDtoMapper;
    }
    @Override
    public void add(TrackDto entity) {
        Album album = this.albumService.getById(entity.getAlbumId());
        Track track = new Track();
        track.setName(entity.getName());
        track.setAlbum(album);
        this.trackRepository.save(track);
    }

    @Override
    public void update(TrackDto entity) {
    Optional<Track> optionalTrack = this.trackRepository.findById(entity.getTrackId());
    optionalTrack.ifPresent(this.trackRepository::save);
    }

    @Override
    public TrackDto delete(Long aLong) {
        Optional<Track> optionalTrack = this.trackRepository.findById(aLong);
        optionalTrack.ifPresent(this.trackRepository::delete);
        return optionalTrack
                .map(trackDtoMapper)
                .orElseThrow();
    }

    @Override
    public TrackDto getById(Long aLong) {
        Optional<Track> optionalTrack = this.trackRepository.findById(aLong);
        return optionalTrack
                .map(trackDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<TrackDto> getAll() {
        List<Track> tracks = this.trackRepository.findAll();
        return tracks
                .stream()
                .map(trackDtoMapper)
                .toList();
    }

    @Override
    public Track getByIdTrack(Long id) {
        Optional<Track> optionalTrack = this.trackRepository.findById(id);
        return optionalTrack.orElseThrow();
    }
}
