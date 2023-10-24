package parcial.backend.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import parcial.backend.entities.*;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackResponse {
    Integer trackId;
    String name;
    Album album;
    MediaType mediaType;
    Genre genre;
    String composer;
    Integer milliseconds;
    Integer bytes;
    Long unitPrice;

    public static TrackResponse from(Track aTrack) {
        return TrackResponse.builder()
                .trackId(aTrack.getTrackId())
                .name(aTrack.getName())
                .album(aTrack.getAlbum())
                .mediaType(aTrack.getMediaType())
                .genre(aTrack.getGenre())
                .composer(aTrack.getComposer())
                .milliseconds(aTrack.getMilliseconds())
                .bytes(aTrack.getBytes())
                .unitPrice(aTrack.getUnitPrice())
                .build();
    }
}