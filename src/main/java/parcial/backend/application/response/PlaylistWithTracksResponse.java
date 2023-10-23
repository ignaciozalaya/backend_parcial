package parcial.backend.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistWithTracksResponse {

    Integer playlistId;
    String name;
    List<Track> tracks;
    public static PlaylistWithTracksResponse from(Playlist aPlaylist) {
        return PlaylistWithTracksResponse.builder()
                .playlistId(aPlaylist.getPlaylistId())
                .name(aPlaylist.getName())
                .tracks(aPlaylist.getTracks())
                .build();
    }
}
