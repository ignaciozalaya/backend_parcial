package parcial.backend.application.controller;

import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.application.ResponseHandler;
import parcial.backend.application.request.CreateArtistRequest;
import parcial.backend.application.request.CreatePlaylistRequest;
import parcial.backend.application.response.ArtistResponse;
import parcial.backend.application.response.PlaylistResponse;
import parcial.backend.service.ArtistService;
import parcial.backend.service.PlaylistService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val responses = playlistService.findAll()
                    .stream()
                    .map(PlaylistResponse::from)
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
            return playlistService.findById(id)
                    .map(playlist -> ResponseHandler.success(PlaylistResponse.from(playlist)))
                    .orElseGet(ResponseHandler::notFound);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreatePlaylistRequest aRequest) {
        try {
            val artist = playlistService.create(aRequest.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody CreatePlaylistRequest aRequest) {
        try {
            playlistService.update(id, aRequest.getName());
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
            playlistService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            //Ya fue borrado, asiq devuelvo 204
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

}
