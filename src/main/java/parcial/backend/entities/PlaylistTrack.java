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
@Table(name = "playlist_track")
public class PlaylistTrack {
    @EmbeddedId
    PlaylistTrackId id;

    @ManyToOne
    @JoinColumn(name = "PlaylistId")
    Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "TrackId")
    Track track;
}

