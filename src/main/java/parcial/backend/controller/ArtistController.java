package parcial.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;
import parcial.backend.service.ArtistService;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> GetAll(){
        List<Artist> artists = artistService.getAll();
        return artists.stream().toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id")Long id) {
        try {
            Artist artist = artistService.getById(id);
            return ResponseEntity.ok(artist);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping
    public ResponseEntity<Object> addArtist(@RequestBody Artist artist) {
        try {
            if (artist.getName() == null || artist.getName().isEmpty()) {
                return ResponseEntity.badRequest().body("El campo 'name' es requerido.");
            }

            artistService.add(artist);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el artista: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArtist(@PathVariable("id")Long id) {
        try {
            artistService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping()
    public ResponseEntity<Object> updateArtist(@RequestBody Artist artist) {
        try {

            artistService.update(artist);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
