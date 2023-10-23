package parcial.backend.application.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePlaylistRequest {
    @NotBlank(message = "name is mandatory")
    String name;
}
