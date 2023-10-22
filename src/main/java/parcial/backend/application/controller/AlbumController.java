package parcial.backend.application.controller;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.application.ResponseHandler;
import parcial.backend.application.request.CreateAlbumRequest;
import parcial.backend.entities.Album;
import parcial.backend.service.AlbumService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping()
    public List<Album> albums() {
        List<Album> albums = albumService.getAll();
        return albums.stream().toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> albumId(@PathVariable("id")Integer id) {
        try {
            Album album = albumService.getById(id);
            return ResponseEntity.ok(album);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Agregar un nuevo álbum
    @PostMapping
    public ResponseEntity<Object> addAlbum(@RequestBody CreateAlbumRequest aRequest) {
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
}
