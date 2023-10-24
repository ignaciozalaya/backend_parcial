package parcial.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.backend.entities.Album;
import parcial.backend.entities.AlbumRequest;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.AlbumRepository;
import parcial.backend.service.AlbumService;
import parcial.backend.service.ArtistService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ArtistService artistService;

    @Autowired
    public AlbumController(AlbumService albumService, ArtistService artistService){
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping()
    public List<Album> getAll() {
        List<Album> albums = albumService.getAll();
        return albums.stream().toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id")Long id) {
        try {
            Album album = albumService.getById(id);
            return ResponseEntity.ok(album);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> addAlbum(@RequestBody AlbumRequest albumRequest) {
        try {
            Artist artist;
            if (albumRequest.getArtistId() != null) {
                // Si se proporciona un ID de artista, busca el artista en la base de datos
                artist = artistService.getById(albumRequest.getArtistId());
                if (artist == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artista no encontrado.");
                }
            } else {
                // Si no se proporciona un ID de artista, crea un nuevo artista
                artist = new Artist();
                artist.setName(albumRequest.getArtistName());
                artistService.add(artist);
            }

            Album album = new Album();
            album.setTitle(albumRequest.getTitle());
            album.setArtist(artist);

            albumService.add(album);
            return ResponseEntity.status(HttpStatus.CREATED).body(album);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el álbum: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAlbum(@PathVariable("id") Long id) {
        try {
            albumService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Álbum eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el álbum: " + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAlbum(@PathVariable Long id, @RequestBody AlbumRequest albumRequest) {
        Album album = albumService.getById(id);

        if (album == null) {
            return ResponseEntity.notFound().build();
        }

        // Verifica y actualiza el título del álbum si se proporciona en la solicitud
        if (albumRequest.getTitle() != null) {
            album.setTitle(albumRequest.getTitle());
        } else {
            return ResponseEntity.badRequest().build();
        }

        // Verifica y actualiza el artista asociado al álbum si se proporciona un nuevo artistId
        if (albumRequest.getArtistId() != null) {
            Artist artist = artistService.getById(albumRequest.getArtistId());
            if (artist == null) {
                return ResponseEntity.badRequest().build();
            }
            album.setArtist(artist);
        }

        albumService.update(album);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}