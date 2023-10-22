package parcial.backend.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAlbumRequest {
    @NotBlank(message = "title is mandatory")
    String title;
    @NotBlank(message = "artistName is mandatory")
    String artistName;
}
