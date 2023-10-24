package parcial.backend.serviceImpl;
import org.junit.jupiter.api.Test;
import parcial.backend.entities.Album;
import parcial.backend.entities.Genre;
import parcial.backend.entities.MediaType;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.AlbumService;
import parcial.backend.service.GenreService;
import parcial.backend.service.MediaTypeService;
import parcial.backend.service.mappers.TrackDtoMapper;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackServiceImplTest {

    // Mocks para las dependencias
    private TrackRepository trackRepository = mock(TrackRepository.class);
    private AlbumService albumService = mock(AlbumService.class);
    private GenreService genreService = mock(GenreService.class);
    private MediaTypeService mediaTypeService = mock(MediaTypeService.class);
    private TrackDtoMapper trackDtoMapper = new TrackDtoMapper();

    private TrackServiceImpl trackService = new TrackServiceImpl(trackRepository, albumService, genreService, mediaTypeService, trackDtoMapper);

    @Test
    void testAdd() {
        // Crear un TrackDto de ejemplo
        TrackDto trackDto = new TrackDto();
        trackDto.setAlbumId(1L);
        trackDto.setGenreId(2L);
        trackDto.setMediaTypeId(3L);
        trackDto.setName("Canción de ejemplo");
        trackDto.setMilliseconds(200000);
        trackDto.setUnitPrice(1L);

        // Simular el comportamiento de las dependencias
        Album album = new Album();
        when(albumService.getById(1L)).thenReturn(album);
        Genre genre = new Genre();
        when(genreService.getById(2L)).thenReturn(genre);
        MediaType mediaType = new MediaType();
        when(mediaTypeService.getById(3L)).thenReturn(mediaType);

        // Ejecutar el método que se va a probar
        trackService.add(trackDto);

        // Verificar que el método save del repositorio se llamó una vez
        verify(trackRepository, times(1)).save(any(Track.class));
    }

    @Test
    void testUpdate() {
        // Crear un TrackDto de ejemplo
        TrackDto trackDto = new TrackDto();
        trackDto.setTrackId(1L); // ID existente
        trackDto.setAlbumId(1L);
        trackDto.setGenreId(2L);
        trackDto.setMediaTypeId(3L);
        trackDto.setName("Canción de ejemplo");
        trackDto.setMilliseconds(200000);
        trackDto.setUnitPrice(1L);

        // Simular el comportamiento de las dependencias
        when(trackRepository.findById(1L)).thenReturn(Optional.of(new Track()));
        Album album = new Album();
        when(albumService.getById(1L)).thenReturn(album);
        Genre genre = new Genre();
        when(genreService.getById(2L)).thenReturn(genre);
        MediaType mediaType = new MediaType();
        when(mediaTypeService.getById(3L)).thenReturn(mediaType);

        // Ejecutar el método que se va a probar
        trackService.update(trackDto);

        // Verificar que el método save del repositorio se llamó una vez
        verify(trackRepository, times(1)).save(any(Track.class));
    }

    @Test
    void testDelete() {
        // Simular el comportamiento del repositorio al buscar un Track por ID
        when(trackRepository.findById(1L)).thenReturn(Optional.of(new Track()));

        // Ejecutar el método que se va a probar
        TrackDto result = trackService.delete(1L);

        // Verificar que el método delete del repositorio se llamó una vez
        verify(trackRepository, times(1)).delete(any(Track.class));
        assertNotNull(result);
    }

    @Test
    void testGetById() {
        //Realizar test de getById
        // Simular el comportamiento del repositorio al buscar un Track por ID
        when(trackRepository.findById(1L)).thenReturn(Optional.of(new Track()));

        // Ejecutar el método que se va a probar
        TrackDto result = trackService.getById(1L);

        // Verificar que el método delete del repositorio se llamó una vez
        assertNotNull(result);


    }

    @Test
    void testGetAll() {
        // Simular el comportamiento del repositorio al devolver una lista de Tracks
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track());
        when(trackRepository.findAll()).thenReturn(tracks);

        // Ejecutar el método que se va a probar
        List<TrackDto> results = trackService.getAll();

        assertFalse(results.isEmpty());
    }

    @Test
    void testGetByIdTrack() {
        // Simular el comportamiento del repositorio al buscar un Track por ID
        when(trackRepository.findById(1L)).thenReturn(Optional.of(new Track()));

        // Ejecutar el método que se va a probar
        Track result = trackService.getByIdTrack(1L);

        assertNotNull(result);
    }
}
