package parcial.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.service.TrackService;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TracksController {
    private final TrackService trackService;

    @Autowired
    public TracksController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping()
    public List<Track> tracks() {
        List<Track> tracks = trackService.getAll();
        return tracks.stream().toList();
    }


}
