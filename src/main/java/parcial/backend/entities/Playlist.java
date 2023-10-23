package parcial.backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = Playlist.TABLE_NAME)
public class Playlist {
    public static final String TABLE_NAME = "playlists";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer playlistId;

    @Column(length = 120, nullable = false)
    String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId")
    )
    @JsonIgnore
    List<Track> tracks;

    public Playlist(Integer playlistId, String name) {
        this.playlistId= playlistId;
        this.name = name;
    }
    public void update(String name ) {
        this.name = name;
    }
}
