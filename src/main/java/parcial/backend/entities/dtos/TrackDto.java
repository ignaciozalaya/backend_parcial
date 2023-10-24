package parcial.backend.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parcial.backend.entities.Album;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
    Long trackId;
    String name;
    Long albumId;
    Long mediaTypeId;
    Long genreId;
    Integer milliseconds;
    Long unitPrice;
}
