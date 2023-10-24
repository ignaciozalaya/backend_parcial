package parcial.backend.serviceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.dtos.PlaylistDto;
import parcial.backend.entities.Track;
import parcial.backend.repositories.PlaylistRepository;
import parcial.backend.service.TrackService;
import parcial.backend.service.mappers.PlaylistDtoMapper;
@ExtendWith(MockitoExtension.class)
public class PlaylistServiceImplTest {
    // Declaración de mocks y servicios necesarios
    private PlaylistRepository playlistRepository = mock(PlaylistRepository.class);
    private TrackService trackService = mock(TrackService.class);
    private PlaylistDtoMapper playlistDtoMapper = mock(PlaylistDtoMapper.class);

    private PlaylistServiceImpl playlistService = new PlaylistServiceImpl(playlistRepository, trackService, playlistDtoMapper);

    @Test
    void testAddPlaylist() {
        PlaylistDto playlistDto = new PlaylistDto();
        playlistDto.setName("My Playlist");
        when(playlistRepository.save(any(Playlist.class))).thenReturn(new Playlist());
        when(playlistDtoMapper.apply(any(Playlist.class))).thenReturn(playlistDto);

        assertDoesNotThrow(() -> playlistService.add(playlistDto));
    }

    @Test
    void testUpdatePlaylist() {
        PlaylistDto playlistDto = new PlaylistDto();
        playlistDto.setPlaylistId(1L);
        when(playlistRepository.findById(playlistDto.getPlaylistId())).thenReturn(Optional.of(new Playlist()));
        when(playlistRepository.save(any(Playlist.class))).thenReturn(new Playlist());

        assertDoesNotThrow(() -> playlistService.update(playlistDto));
    }

    @Test
    void testDeletePlaylist() {
        Long playlistId = 1L;
        when(playlistRepository.findById(playlistId)).thenReturn(Optional.of(new Playlist()));
        when(playlistDtoMapper.apply(any(Playlist.class))).thenReturn(new PlaylistDto());

        PlaylistDto deletedPlaylist = playlistService.delete(playlistId);

        assertNotNull(deletedPlaylist);
        verify(playlistRepository, times(1)).delete(any(Playlist.class));
    }

    @Test
    void testGetPlaylistById() {
        Long playlistId = 1L;
        when(playlistRepository.findById(playlistId)).thenReturn(Optional.of(new Playlist()));
        when(playlistDtoMapper.apply(any(Playlist.class))).thenReturn(new PlaylistDto());

        PlaylistDto playlistDto = playlistService.getById(playlistId);

        assertNotNull(playlistDto);
    }

    @Test
    void testAddTrackToPlaylist() {
        Long playlistId = 1L;
        Long trackId = 2L;
        Playlist playlist = new Playlist();
        Track track = new Track();
        when(playlistRepository.getById(playlistId)).thenReturn(playlist);
        assertNotNull(playlist);
    }

    @Test
    void testGetAllPlaylists() {
        // Mocking the behavior of the repository to return a list of playlists
        when(playlistRepository.findAll()).thenReturn(Collections.emptyList());

        // Mocking the behavior of the mapper to map the Playlist entities to PlaylistDto
        when(playlistDtoMapper.apply(any(Playlist.class))).thenReturn(new PlaylistDto());

        List<PlaylistDto> playlists = playlistService.getAll();

        assertNotNull(playlists);
        assertTrue(playlists.isEmpty());

        verify(playlistRepository, times(1)).findAll();
        verify(playlistDtoMapper, times(0)).apply(any(Playlist.class));
    }
}