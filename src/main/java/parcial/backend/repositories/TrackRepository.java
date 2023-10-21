package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Track;
@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}