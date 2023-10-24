package parcial.backend.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import parcial.backend.entities.MediaType;
import parcial.backend.repositories.MediaTypeRepository;
import parcial.backend.service.MediaTypeService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MediaTypeServiceImplTest {

    @Mock
    private MediaTypeRepository mediaTypeRepository;

    private MediaTypeService mediaTypeService;

    @BeforeEach
    public void setup() {
        mediaTypeService = new MediaTypeServiceImpl(mediaTypeRepository);
    }

    @Test
    public void testGetMediaTypeById() {
        MediaType expectedMediaType = new MediaType();
        expectedMediaType.setMediaTypeId(1L);
        expectedMediaType.setName("Audio");


        Mockito.when(mediaTypeRepository.findById(1L)).thenReturn(Optional.of(expectedMediaType));

        MediaType actualMediaType = mediaTypeService.getById(1L);
        assertEquals(expectedMediaType, actualMediaType);
    }

    @Test
    public void testGetMediaTypeByIdNoEncontrada() {
        Mockito.when(mediaTypeRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> mediaTypeService.getById(2L));
    }
}
