package parcial.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.entities.Album;
import parcial.backend.entities.Track;
import parcial.backend.entities.dtos.TrackDto;
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
    public ResponseEntity<List<TrackDto>>getAll() {
        List<TrackDto> tracks = trackService.getAll();
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getById(@PathVariable("id") Long trackId){
        try {
            TrackDto track = trackService.getById(trackId);
            return ResponseEntity.ok(track);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody TrackDto trackDto) {
        try {
            trackService.update(trackDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody TrackDto trackDto) {

        trackService.add(trackDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long trackId) {
        trackService.delete(trackId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
