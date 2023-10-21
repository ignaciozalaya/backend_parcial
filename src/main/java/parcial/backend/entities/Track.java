package parcial.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    Long trackId;

    @Column(length = 200, nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "album_id")
    Album album;

    @ManyToOne
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
}
