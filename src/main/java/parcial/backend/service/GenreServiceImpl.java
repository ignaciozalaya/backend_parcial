package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Genre;
import parcial.backend.repositories.ArtistRepository;
import parcial.backend.repositories.GenreRepository;
import parcial.backend.service.GenreService;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Genre> findByName(String name) {
        return genreRepository.findByName(name);
    }

}
