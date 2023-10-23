package parcial.backend.service;

import parcial.backend.entities.PlaylistTrack;
import parcial.backend.entities.PlaylistTrackId;

public interface PlaylistTrackService extends Service<PlaylistTrack, Long>{
    PlaylistTrack getPlaylistTrackById(Long playlistId, Long trackId);
}
