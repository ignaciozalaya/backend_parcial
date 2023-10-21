package parcial.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long playlistId;

    @Column(length = 120, nullable = false)
    String name;
}
