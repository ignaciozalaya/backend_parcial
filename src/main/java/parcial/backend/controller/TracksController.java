package parcial.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.service.TrackService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/tracks")
public class TracksController {
    private final TrackService trackService;

    @Autowired
    public TracksController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping()
    public List<Track> getAll() {
        List<Track> tracks = trackService.getAll();
        return tracks.stream().toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable("id") Long trackId){
        try {
            Track track = trackService.getById(trackId);
            return ResponseEntity.ok(track);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
