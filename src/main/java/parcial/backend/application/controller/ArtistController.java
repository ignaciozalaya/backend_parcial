package parcial.backend.application.controller;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.application.ResponseHandler;
import parcial.backend.application.request.CreateAlbumRequest;
import parcial.backend.application.request.CreateArtistRequest;
import parcial.backend.application.request.UpdateAlbumRequest;
import parcial.backend.application.response.AlbumResponse;
import parcial.backend.application.response.ArtistResponse;
import parcial.backend.service.AlbumService;
import parcial.backend.service.ArtistService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val responses = artistService.findAll()
                    .stream()
                    .map(ArtistResponse::from)
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
            return artistService.findById(id)
                    .map(aArtist -> ResponseHandler.success(ArtistResponse.from(aArtist)))
                    .orElseGet(ResponseHandler::notFound);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateArtistRequest aRequest) {
        try {
            val artist = artistService.create(aRequest.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody CreateArtistRequest aRequest) {
        try {
            artistService.update(id, aRequest.getName());
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
            artistService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            //Ya fue borrado, asiq devuelvo 204
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

}
