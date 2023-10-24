package parcial.backend.service.mappers;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.dtos.PlaylistDto;

import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class PlaylistDtoMapper implements Function<Playlist, PlaylistDto> {
    @Override
    public PlaylistDto apply(Playlist playlist) {
        return new PlaylistDto(playlist.getPlaylistId(),
                playlist.getName(),
                playlist.getTracks().stream().map(new TrackDtoMapper()).collect(Collectors.toList()));
    }
}
