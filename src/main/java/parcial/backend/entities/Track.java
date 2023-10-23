package parcial.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long trackId;

    @Column(length = 200, nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    Album album;

    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "GenreId")
    Genre genre;

    @Column(length = 220)
    String composer;

    @Column(nullable = false)
    Integer milliseconds;

    Integer bytes;

    @Column(name = "UnitPrice")
    Long unitPrice;

    @ManyToMany(mappedBy = "tracks")
    private List<Playlist> playlists;
}
