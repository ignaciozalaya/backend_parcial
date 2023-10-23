package parcial.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcial.backend.service.PlaylistService;

@RestController
@RequestMapping("/api/playlistTrack")
public class PlaylistTrackController {

    private final PlaylistService playlistService;

    public PlaylistTrackController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @PostMapping("/addTrack/{idPlaylist}/{idTrack}")
    public ResponseEntity<?> addTrackToPlaylist(@PathVariable("idPlaylist") Long idPlaylist, @PathVariable("idTrack") Long idTrack) {
        try {
            return ResponseEntity.ok().body(playlistService.addTrackToPlaylist(idPlaylist, idTrack));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
