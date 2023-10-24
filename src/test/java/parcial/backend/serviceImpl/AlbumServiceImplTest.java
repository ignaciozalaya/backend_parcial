package parcial.backend.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import parcial.backend.entities.Album;
import parcial.backend.repositories.AlbumRepository;
import parcial.backend.service.AlbumService;
import parcial.backend.serviceImpl.AlbumServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumService;

    @Mock
    private AlbumRepository albumRepository;

    @BeforeEach
    public void setUp() {
        // Inicialización o configuración adicional si es necesario
    }

    @Test
    public void testAddAlbum() {
        // Arrange
        Album album = new Album(); // Crea un objeto Album de ejemplo
        when(albumRepository.save(any(Album.class))).thenReturn(album);

        // Act
        albumService.add(album);

        // Assert
        verify(albumRepository).save(album); // Verifica que el método save se haya llamado
    }

    @Test
    public void testGetById() {
        // Arrange
        Long albumId = 1L;
        Album expectedAlbum = new Album();
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(expectedAlbum));

        // Act
        Album retrievedAlbum = albumService.getById(albumId);

        // Assert
        assertEquals(expectedAlbum, retrievedAlbum);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Album> albums = new ArrayList<>();
        when(albumRepository.findAll()).thenReturn(albums);

        // Act
        List<Album> retrievedAlbums = albumService.getAll();

        // Assert
        assertEquals(albums, retrievedAlbums);
    }

    @Test
    public void testUpdateAlbum() {
        // Arrange
        Album album = new Album(); // Crea un objeto Album de ejemplo
        when(albumRepository.save(any(Album.class))).thenReturn(album);

        // Act
        albumService.update(album);

        // Assert
        verify(albumRepository).save(album); // Verifica que el método save se haya llamado
    }

    @Test
    public void testDeleteAlbum() {
        // Arrange
        Long albumId = 1L;
        Album expectedAlbum = new Album();
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(expectedAlbum));

        // Act
        Album deletedAlbum = albumService.delete(albumId);

        // Assert
        verify(albumRepository).delete(expectedAlbum); // Verifica que el método delete se haya llamado con el álbum esperado
        assertEquals(expectedAlbum, deletedAlbum);
    }

    // Puedes continuar creando más pruebas para los demás métodos de AlbumServiceImpl
}