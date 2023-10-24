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
@Table(name = Track.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Track {
    public static final String TABLE_NAME = "tracks";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer trackId;

    @Column(length = 200, nullable = false)
    String name;

    @ManyToMany(mappedBy = "tracks")
    List<Playlist> playlists;

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

    public void update(String name,
                       Album album,
                       MediaType mediaType,
                       Genre genre,
                       String composer,
                       Integer milliseconds,
                       Integer bytes,
                       Long unitPrice) {
        this.name = name;
        this.album = album;
        this.mediaType = mediaType;
        this.genre = genre;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }
}

