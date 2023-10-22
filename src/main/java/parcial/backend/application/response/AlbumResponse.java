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
public class AlbumResponse {
    Integer id;
    String title;
    Artist artist;

    public static AlbumResponse from(Album aAlbum) {
        return AlbumResponse.builder()
                .id(aAlbum.getAlbumId())
                .title(aAlbum.getTitle())
                .artist(aAlbum.getArtist())
                .build();
    }

}
