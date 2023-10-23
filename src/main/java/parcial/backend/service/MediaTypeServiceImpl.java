package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.MediaType;
import parcial.backend.service.MediaTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class MediaTypeServiceImpl implements MediaTypeService {

    @Override
    public List<MediaType> findAll() {
        return null;
    }

    @Override
    public Optional<MediaType> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
