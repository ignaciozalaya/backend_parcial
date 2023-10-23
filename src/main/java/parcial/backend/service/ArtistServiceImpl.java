package parcial.backend.service;

import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.ArtistRepository;
import parcial.backend.repositories.IdentifierRepository;
import parcial.backend.service.ArtistService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final IdentifierRepository identifierRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository,
                             IdentifierRepository identifierRepository) {
        this.artistRepository = artistRepository;
        this.identifierRepository = identifierRepository;
    }

    @Override
    public Optional<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    @Transactional
    public Artist create(String name) {
        val artistId = identifierRepository.nextValue(Artist.TABLE_NAME);
        val artist = new Artist(artistId,name );
        return artistRepository.save(artist);
    }

    @Override
    @Transactional
    public void update(Integer id, String name) {
        // Actualizar un artist
        val artist = artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artist not Found"));
        artist.update(name);
        artistRepository.save(artist);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Integer id) {
        return artistRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        try {
            artistRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Artist not found");
        }
    }
}
