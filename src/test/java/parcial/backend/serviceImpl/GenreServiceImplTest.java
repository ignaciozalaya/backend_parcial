package parcial.backend.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import parcial.backend.entities.Genre;
import parcial.backend.repositories.GenreRepository;
import parcial.backend.service.GenreService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class GenreServiceImplTest {

    @Mock
    private GenreRepository genreRepository;

    private GenreService genreService;

    @BeforeEach
    public void setup() {
        genreService = new GenreServiceImpl(genreRepository);
    }

    @Test
    public void testGetGenreById() {
        Genre expectedGenre = new Genre();
        expectedGenre.setGenreId(1L);
        expectedGenre.setName("Drama");

        Mockito.when(genreRepository.findById(1L)).thenReturn(Optional.of(expectedGenre));
        Genre actualGenre = genreService.getById(1L);
        assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testGetGenreByIdNoEncontrado() {
        Mockito.when(genreRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> genreService.getById(2L));
    }
}
