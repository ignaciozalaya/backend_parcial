package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.PlaylistTrack;
import parcial.backend.entities.PlaylistTrackId;

@Repository
public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack, Long> {
//    PlaylistTrack findByPlaylistIdAndTrackId(Long playlistId, Long trackId);
}
