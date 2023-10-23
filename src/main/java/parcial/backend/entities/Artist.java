package parcial.backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name =Artist.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist {
    public static final String TABLE_NAME = "artists";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer artistId;

    @Column(length = 120)
    String name;

    public void update(String name ) {
        this.name = name;
    }

}