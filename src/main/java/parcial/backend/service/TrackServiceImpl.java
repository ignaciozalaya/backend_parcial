package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.TrackService;

import java.util.List;
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
        return null;
    }

    @Override
    public List<Track> getAll() {
        List<Track> tracks = this.trackRepository.findAll();
        return tracks
                .stream()
                .toList();
    }
}
