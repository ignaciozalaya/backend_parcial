package parcial.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
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
@Table(name = MediaType.TABLE_NAME)
public class MediaType {
    public static final String TABLE_NAME = "media_types";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mediaTypeId;

    @Column(length = 120, nullable = false)
    String name;
}
