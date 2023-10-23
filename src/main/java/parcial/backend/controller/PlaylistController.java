package parcial.backend.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.entities.Artist;
import parcial.backend.entities.Playlist;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(@Qualifier("playlistServiceImpl") PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @GetMapping
    public List<Playlist> GetAll(){
        List<Playlist> playlists = playlistService.getAll();
        return playlists.stream().toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable ("id") Long id ){
        try {
            Playlist playlist = playlistService.getById(id);
            return ResponseEntity.ok(playlist);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> addPlaylist(@RequestBody Playlist playlist) {
        try {
            if (playlist.getName() == null || playlist.getName().isEmpty()) {
                return ResponseEntity.badRequest().body("El campo 'name' es requerido.");
            }

            playlistService.add(playlist);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la playlist: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable("id")Long id) {
        try {
            playlistService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updatePlaylist(@PathVariable("id")Long id, @RequestBody Playlist playlist) {
        try {
            playlistService.update(playlist);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
