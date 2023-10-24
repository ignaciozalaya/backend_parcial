package parcial.backend.application.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import parcial.backend.entities.Album;
import parcial.backend.entities.Genre;
import parcial.backend.entities.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTrackRequest {

    @NotBlank(message = "name is mandatory")
    String name;
    @NotBlank(message = "albumName is mandatory")
    String albumName;
    @NotBlank(message = "mediaTypeName is mandatory")
    String mediaTypeName;
    @NotBlank(message = "mediaTypeName is mandatory")
    String genreName;
    @NotBlank(message = "composer is mandatory")
    String composer;
    @NotNull(message = "milliseconds is mandatory")
    Integer milliseconds;
    @NotNull(message = "bytes is mandatory")
    Integer bytes;
    @NotNull(message = "unitPrice is mandatory")
    Long unitPrice;
}

