package parcial.backend.service;

import parcial.backend.entities.Artist;
import parcial.backend.entities.MediaType;

import java.util.Optional;

public interface MediaTypeService extends Service<MediaType, Long>{
    Optional<MediaType> findByName(String name);
}
