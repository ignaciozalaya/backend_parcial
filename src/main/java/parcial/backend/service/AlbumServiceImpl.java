package parcial.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;
import parcial.backend.repositories.AlbumRepository;
import parcial.backend.repositories.IdentifierRepository;
import parcial.backend.service.AlbumService;

import java.util.List;
import java.util.Optional;

import lombok.val;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final IdentifierRepository identifierRepository;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository,
                            ArtistService artistService,
                            IdentifierRepository identifierRepository) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.identifierRepository = identifierRepository;
    }

    @Override
    @Transactional
    public Album create(String title, String artistName) {
        // Crear un album asociando un artist
        val artist = artistService.findByName(artistName).orElseThrow(() -> new IllegalArgumentException("Artist not Found"));
        val albumId = identifierRepository.nextValue(Album.TABLE_NAME);
        val album = new Album(albumId, title, artist);

        return albumRepository.save(album);
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Integer id) {
        return albumRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(final Integer id) {
        try {
            albumRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Album not found");
        }
    }

    @Override
    @Transactional
    public void update(Integer id, String title, String artistName) {
        // Actualizar un album asociando un artist
        val album = albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Album not Found"));
        val artist = artistService.findByName(artistName).
                orElseThrow(() -> new IllegalArgumentException("Artist not Found"));
        album.update(title, artist);
        albumRepository.save(album);
    }

    @Override
    public Optional<Album> findByName(String name) {
        return albumRepository.findByName(name);
    }
}
