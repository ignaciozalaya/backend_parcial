package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Genre;
import parcial.backend.entities.MediaType;

import java.util.Optional;

@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {

    Optional<MediaType> findByName(String Name);
}