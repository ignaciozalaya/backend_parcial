package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.ArtistRepository;
import parcial.backend.service.ArtistService;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void add(Artist entity) { this.artistRepository.save(entity);}

    @Override
    public void update(Artist entity) { this.artistRepository.save(entity);}

    @Override
    public Artist delete(Long aLong) {
        Optional<Artist> artistOptional = artistRepository.findById(aLong);
        artistOptional.ifPresent(this.artistRepository::delete);
        return artistOptional.orElseThrow();
    }

    @Override
    public Artist getById(Long aLong) {
        Optional<Artist> artistOptional = artistRepository.findById(aLong);
        return artistOptional.
                orElseThrow();
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> artist = this.artistRepository.findAll();
        return artist
                .stream()
                .toList();
    }
}
