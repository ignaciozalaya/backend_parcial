package parcial.backend.service.mappers;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;

import java.util.function.Function;
@Service
public class TrackDtoMapper implements Function<Track, TrackDto> {
    @Override
    public TrackDto apply(Track track) {
        return new TrackDto(track.getTrackId(),
                track.getName(),
                track.getAlbum().getAlbumId());
    }
}
