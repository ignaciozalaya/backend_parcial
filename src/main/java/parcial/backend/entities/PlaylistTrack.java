package parcial.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = PlaylistTrack.TABLE_NAME)
public class PlaylistTrack {
    public static final String TABLE_NAME = "playlist_track";
    @EmbeddedId
    PlaylistTrackId id;

    @ManyToOne
    @MapsId("playlistId")
    Playlist playlist;

    @ManyToOne
    @MapsId("trackId")
    Track track;
}

