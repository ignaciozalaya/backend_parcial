package parcial.backend.serviceImpl;

import org.springframework.stereotype.Service;
import parcial.backend.entities.MediaType;
import parcial.backend.repositories.MediaTypeRepository;
import parcial.backend.service.MediaTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class MediaTypeServiceImpl implements MediaTypeService {
    private final MediaTypeRepository mediaTypeRepository;

    public MediaTypeServiceImpl(MediaTypeRepository genreRepository) {
        this.mediaTypeRepository = genreRepository;
    }

    @Override
    public void add(MediaType entity) {

    }

    @Override
    public void update(MediaType entity) {

    }

    @Override
    public MediaType delete(Long aLong) {
        return null;
    }

    @Override
    public MediaType getById(Long aLong) {
        Optional<MediaType> mediaTypeOptional = mediaTypeRepository.findById(aLong);
        return mediaTypeOptional.
                orElseThrow();
    }

    @Override
    public List<MediaType> getAll() {
        return null;
    }
}
