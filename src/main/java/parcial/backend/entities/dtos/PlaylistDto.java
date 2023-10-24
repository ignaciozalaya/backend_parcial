package parcial.backend.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto {
    Long playlistId;
    String name;
    List<TrackDto> tracks;
}