package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.ArtistRepository;
import parcial.backend.service.ArtistService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Optional<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public List<Artist> findAll() {
        return null;
    }

    @Override
    public Optional<Artist> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }
}
