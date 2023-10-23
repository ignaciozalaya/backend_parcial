package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.TrackService;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    public TrackServiceImpl( TrackRepository trackRepository ) {
        this.trackRepository = trackRepository;
    }
    @Override
    public void add(Track entity) {

    }

    @Override
    public void update(Track entity) {

    }

    @Override
    public Track delete(Long aLong) {
        return null;
    }

    @Override
    public Track getById(Long aLong) {
        Optional<Track> optionalTrack = this.trackRepository.findById(aLong);
        return optionalTrack
                .orElseThrow();

    }

    @Override
    public List<Track> getAll() {
        List<Track> tracks = this.trackRepository.findAll();
        return tracks
                .stream()
                .toList();
    }
}
