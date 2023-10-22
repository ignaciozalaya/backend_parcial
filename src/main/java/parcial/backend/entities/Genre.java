package parcial.backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = Genre.TABLE_NAME)
public class Genre {
    public static final String TABLE_NAME = "genres";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long genreId;

    @Column(length = 120, nullable = false)
    String name;
}