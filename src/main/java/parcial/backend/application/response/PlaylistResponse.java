package parcial.backend.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponse {

    Integer playlistId;
    String name;

    public static PlaylistResponse from(Playlist aPlaylist) {
        return PlaylistResponse.builder()
                .playlistId(aPlaylist.getPlaylistId())
                .name(aPlaylist.getName())
                .build();
    }
}
