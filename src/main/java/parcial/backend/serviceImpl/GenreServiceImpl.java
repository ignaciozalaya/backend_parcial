package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Genre;
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
    public void add(Genre entity) {

    }

    @Override
    public void update(Genre entity) {

    }

    @Override
    public Genre delete(Long aLong) {
        return null;
    }

    @Override
    public Genre getById(Long aLong) {
        Optional<Genre> genreOptional = genreRepository.findById(aLong);
        return genreOptional.
                orElseThrow();
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }
}
