package parcial.backend.service;

import parcial.backend.entities.Playlist;
import parcial.backend.entities.dtos.PlaylistDto;

public interface PlaylistService extends Service<PlaylistDto, Long> {
    PlaylistDto addTrackToPlaylist(Long idPlaylist, Long idTrack);

}
