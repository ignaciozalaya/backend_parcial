package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//    Playlist update(Long id, Playlist playlist);
}