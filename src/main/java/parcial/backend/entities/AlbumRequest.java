package parcial.backend.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;


@Data
@Validated
public class AlbumRequest {
    @NotBlank
    private String title;
    private Long artistId;
    private String artistName;
}