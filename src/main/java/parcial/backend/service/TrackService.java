package parcial.backend.service;

import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;

public interface TrackService extends Service<TrackDto, Long>{
    public Track getByIdTrack(Long id);
}
