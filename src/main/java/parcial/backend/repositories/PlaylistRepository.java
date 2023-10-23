package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Playlist;

import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    @Query("SELECT p FROM Playlist p LEFT JOIN FETCH p.tracks WHERE p.playlistId = :playlistId")
    Optional<Playlist> findByIdWithTracks(@Param("playlistId") Integer playlistId);
}