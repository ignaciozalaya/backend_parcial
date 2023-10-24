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
import parcial.backend.application.response.PlaylistWithTracksResponse;
import parcial.backend.entities.Playlist;
import parcial.backend.entities.Track;
import parcial.backend.service.ArtistService;
import parcial.backend.service.PlaylistService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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


    @GetMapping("/byTrack/{trackId}")
    public ResponseEntity<Object> getPlaylistsByTrackId(@PathVariable Integer trackId) {
        try {
            val responses = playlistService.findAllByTracksTrackId(trackId)
                    .stream()
                    .map(PlaylistResponse::from)
                    .toList();
            return ResponseHandler.success(responses);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") Integer id) {
        try {
            Optional<Playlist> optionalPlaylist = playlistService.findById(id);
            if (optionalPlaylist.isPresent()) {
                Playlist playlist = optionalPlaylist.get();
                List<Track> top10Tracks = playlist.getTracks().subList(0, Math.min(10, playlist.getTracks().size()));
                playlist.setTracks(top10Tracks);
                return ResponseHandler.success(PlaylistWithTracksResponse.from(playlist));
            }else {
                return ResponseHandler.notFound();
            }
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