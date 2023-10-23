package parcial.backend.application.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateAlbumRequest {
    @NotBlank(message = "title is mandatory")
    String title;
//    @NotBlank(message = "id is mandatory")
//    Integer id;
    @NotBlank(message = "artistName is mandatory")
    String artistName;
}
