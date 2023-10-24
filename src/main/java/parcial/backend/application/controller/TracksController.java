package parcial.backend.application.controller;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.application.ResponseHandler;
import parcial.backend.application.request.CreateAlbumRequest;
import parcial.backend.application.request.CreatePlaylistRequest;
import parcial.backend.application.request.CreateTrackRequest;
import parcial.backend.application.request.UpdateAlbumRequest;
import parcial.backend.application.response.ArtistResponse;
import parcial.backend.application.response.PlaylistResponse;
import parcial.backend.application.response.PlaylistWithTracksResponse;
import parcial.backend.application.response.TrackResponse;
import parcial.backend.entities.Album;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;
import parcial.backend.service.TrackService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/tracks")
public class TracksController {
    private final TrackService trackService;

    @Autowired
    public TracksController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val responses = trackService.findAll()
                    .stream()
                    .map(TrackResponse::from)
                    .toList();
            return ResponseHandler.success(responses);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") Integer id) {
        try {
            return trackService.findById(id)
                    .map(track -> ResponseHandler.success(TrackResponse.from(track)))
                    .orElseGet(ResponseHandler::notFound);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateTrackRequest aRequest) {
        try {
            val track = trackService.create(
                    aRequest.getName(),
                    aRequest.getAlbumName(),
                    aRequest.getMediaTypeName(),
                    aRequest.getGenreName(),
                    aRequest.getComposer(),
                    aRequest.getMilliseconds(),
                    aRequest.getBytes(),
                    aRequest.getUnitPrice());

            return ResponseEntity.status(HttpStatus.CREATED).body(track);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody CreateTrackRequest aRequest) {
        try {
            trackService.update(id,
                    aRequest.getName(),
                    aRequest.getAlbumName(),
                    aRequest.getMediaTypeName(),
                    aRequest.getGenreName(),
                    aRequest.getComposer(),
                    aRequest.getMilliseconds(),
                    aRequest.getBytes(),
                    aRequest.getUnitPrice());
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            trackService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            //Ya fue borrado, asiq devuelvo 204
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
