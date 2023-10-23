package parcial.backend.application.controller;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.application.ResponseHandler;
import parcial.backend.application.request.CreateAlbumRequest;
import parcial.backend.application.request.UpdateAlbumRequest;
import parcial.backend.application.response.AlbumResponse;
import parcial.backend.service.AlbumService;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val responses = albumService.findAll()
                    .stream()
                    .map(AlbumResponse::from)
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
            return albumService.findById(id)
                    .map(aCustomer -> ResponseHandler.success(AlbumResponse.from(aCustomer)))
                    .orElseGet(ResponseHandler::notFound);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Agregar un nuevo álbum
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateAlbumRequest aRequest) {
        try {
            val album = albumService.create(
                    aRequest.getTitle(),
                    aRequest.getArtistName()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(album);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody UpdateAlbumRequest aRequest) {
        try {
            albumService.update(id, aRequest.getTitle(), aRequest.getArtistName());
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
            albumService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            //Ya fue borrado, asiq devuelvo 204
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }


}
