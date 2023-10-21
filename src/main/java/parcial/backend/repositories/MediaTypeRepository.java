package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.MediaType;
@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {
}