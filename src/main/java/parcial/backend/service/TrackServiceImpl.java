package parcial.backend.service;

import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.backend.entities.*;
import parcial.backend.repositories.IdentifierRepository;
import parcial.backend.repositories.TrackRepository;
import parcial.backend.service.TrackService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final IdentifierRepository identifierRepository;

    private final AlbumService albumService;
    private final MediaTypeService mediaTypeService;
    private final GenreService genreService;


    public TrackServiceImpl(
            TrackRepository trackRepository,
            IdentifierRepository identifierRepository,
            AlbumService albumService,
            MediaTypeService mediaTypeService,
            GenreService genreService) {
        this.trackRepository = trackRepository;
        this.identifierRepository = identifierRepository;
        this.albumService = albumService;
        this.mediaTypeService = mediaTypeService;
        this.genreService = genreService;
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> findById(Integer id) {
        return trackRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(final Integer id) {
        try {
            trackRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Track not found");
        }
    }

    @Override
    @Transactional
    public Track create(String name,
                        String albumName,
                        String mediaTypeName,
                        String genreName,
                        String composer,
                        Integer milliseconds,
                        Integer bytes,
                        Long unitPrice) {

        Album album = (Album) this.albumService.findByName(albumName).orElseThrow(() -> {
            return new IllegalArgumentException("Album not Found");
        });
        MediaType mediaType = (MediaType) this.mediaTypeService.findByName(mediaTypeName).orElseThrow(() -> {
            return new IllegalArgumentException("MediaType not Found");
        });
        Genre genre = (Genre) this.genreService.findByName(genreName).orElseThrow(() -> {
            return new IllegalArgumentException("Genre not Found");
        });


        val trackId = identifierRepository.nextValue(Track.TABLE_NAME);
        val playlists = new ArrayList<Playlist>();

        val track = new Track(trackId,
                name,
                playlists,
                album,
                mediaType,
                genre,
                composer,
                milliseconds,
                bytes,
                unitPrice);

        return trackRepository.save(track);
    }


    @Override
    @Transactional
    public void update(Integer id,
                       String name,
                       String albumName,
                       String mediaTypeName,
                       String genreName,
                       String composer,
                       Integer milliseconds,
                       Integer bytes,
                       Long unitPrice) {
        val track = trackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Track not Found"));
        var album = albumService.findByName(albumName).
                orElseThrow(() -> new IllegalArgumentException("Album not Found"));
        var mediaType = mediaTypeService.findByName(mediaTypeName).
                orElseThrow(() -> new IllegalArgumentException("MediaType not Found"));
        var genre = genreService.findByName(genreName).
                orElseThrow(() -> new IllegalArgumentException("Genre not Found"));
        track.update(name,
                album,
                mediaType,
                genre,
                composer,
                milliseconds,
                bytes,
                unitPrice);
        trackRepository.save(track);
    }

}

