package parcial.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import parcial.backend.entities.dtos.TrackDto;

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
    @NotNull
    Long unitPrice;

    @ManyToMany(mappedBy = "tracks")
    private List<Playlist> playlists;


    public TrackDto toDto(){
//        if (this.album != null) {
//            return new TrackDto(this.trackId, this.name, this.album.getAlbumId(), this.mediaType.getMediaTypeId(), this.genre.getGenreId(), this.milliseconds, this.unitPrice);
//        } else {
//            // Maneja el caso en el que album es nulo
//            return new TrackDto(this.trackId, this.name, null, this.mediaType.getMediaTypeId(), this.genre.getGenreId(), this.milliseconds, this.unitPrice);
//        }
        return new TrackDto(
                this.trackId,
                this.name,
                this.album.getAlbumId(),
                this.mediaType.getMediaTypeId(),
                this.genre.getGenreId(),
                this.milliseconds,
                this.unitPrice
        );
    }
}
