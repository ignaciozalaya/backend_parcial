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
@Table(name = Playlist.TABLE_NAME)
public class Playlist {
    public static final String TABLE_NAME = "playlists";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer playlistId;

    @Column(length = 120, nullable = false)
    String name;

    public void update(String name ) {
        this.name = name;
    }
}
