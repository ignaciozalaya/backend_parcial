package parcial.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlaylistTrackId implements Serializable {
    private Long playlistId;
    private Long trackId;

    // Constructor, getters y setters
    // Asegúrate de implementar hashCode y equals correctamente
}
