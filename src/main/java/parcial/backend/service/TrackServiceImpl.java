package parcial.backend.service;

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

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> findAll() {
        return null;
    }

    @Override
    public Optional<Track> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}

