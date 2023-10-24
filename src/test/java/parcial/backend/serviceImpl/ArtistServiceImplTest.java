package parcial.backend.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.ArtistRepository;
import parcial.backend.serviceImpl.ArtistServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArtistServiceImplTest {

    @InjectMocks
    private ArtistServiceImpl artistService;

    @Mock
    private ArtistRepository artistRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddArtist() {
        Artist artist = new Artist();
        artist.setName("Test Artist");

        when(artistRepository.save(any())).thenReturn(artist);

        artistService.add(artist);

        verify(artistRepository, times(1)).save(artist);
    }

    @Test
    void testUpdateArtist() {
        Artist existingArtist = new Artist();
        existingArtist.setArtistId(1L);
        existingArtist.setName("Existing Artist");

        Artist updatedArtist = new Artist();
        updatedArtist.setArtistId(1L);
        updatedArtist.setName("Updated Artist");

        when(artistRepository.findById(1L)).thenReturn(Optional.of(existingArtist));
        when(artistRepository.save(any())).thenReturn(updatedArtist);

        artistService.update(updatedArtist);

        verify(artistRepository, times(1)).save(existingArtist);
    }

    @Test
    void testUpdateArtistWithNullId() {
        Artist artistWithNullId = new Artist();
        artistWithNullId.setName("Artist with Null ID");

        assertThrows(IllegalArgumentException.class, () -> artistService.update(artistWithNullId));
    }

    @Test
    void testDeleteArtist() {
        Artist artist = new Artist();
        artist.setArtistId(1L);

        when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        Artist deletedArtist = artistService.delete(1L);

        assertNotNull(deletedArtist);
        assertEquals(1L, deletedArtist.getArtistId());

        verify(artistRepository, times(1)).delete(artist);
    }

    @Test
    void testGetArtistById() {
        Artist artist = new Artist();
        artist.setArtistId(1L);

        when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        Artist retrievedArtist = artistService.getById(1L);

        assertNotNull(retrievedArtist);
        assertEquals(1L, retrievedArtist.getArtistId());
    }

    @Test
    void testGetArtistByIdNonExistent() {
        when(artistRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> artistService.getById(1L));
    }

    @Test
    void testGetAllArtists() {
        List<Artist> artists = new ArrayList<>();
        Artist artist1 = new Artist();
        artist1.setArtistId(1L);
        artist1.setName("Artist 1");
        Artist artist2 = new Artist();
        artist2.setArtistId(2L);
        artist2.setName("Artist 2");
        artists.add(artist1);
        artists.add(artist2);

        when(artistRepository.findAll()).thenReturn(artists);

        List<Artist> retrievedArtists = artistService.getAll();

        assertEquals(2, retrievedArtists.size());
        assertEquals(1L, retrievedArtists.get(0).getArtistId());
        assertEquals(2L, retrievedArtists.get(1).getArtistId());
    }
}