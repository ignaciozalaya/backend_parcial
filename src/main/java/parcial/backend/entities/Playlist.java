package parcial.backend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import parcial.backend.entities.dtos.PlaylistDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long playlistId;

    @Column(length = 120, nullable = false)
    String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId")
    )
    private List<Track> tracks;
    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }
    public Playlist addTrack(Track track) {
        this.tracks.add(track);
        return this;
    }
    public PlaylistDto toDto(){
        if (this.tracks == null) return new PlaylistDto(this.playlistId, this.name, new ArrayList<>());
        return new PlaylistDto(this.playlistId, this.name, this.tracks.stream().map(Track::toDto).toList());
    }
}
