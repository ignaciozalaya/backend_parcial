package parcial.backend.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistResponse {
    Integer artistId;
    String name;

    public static ArtistResponse from(Artist aArtist) {
        return ArtistResponse.builder()
                .artistId(aArtist.getArtistId())
                .name(aArtist.getName())
                .build();
    }
}
