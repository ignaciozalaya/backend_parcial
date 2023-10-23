package parcial.backend.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
//    @GetMapping("/{id}")
//    public Playlist getById(Long id){
//        try {
//            Playlist playlist = playlistService.getById(id);
//            return ResponseEntity.ok(playlist);
//        } catch (NoSuchElementException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
}
