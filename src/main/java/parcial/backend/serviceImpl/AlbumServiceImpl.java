package parcial.backend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.backend.entities.Album;
import parcial.backend.repositories.AlbumRepository;
import parcial.backend.service.AlbumService;

import java.util.List;
import java.util.Optional;


@Service
public class AlbumServiceImpl implements AlbumService {


    private final AlbumRepository albumRepository;

    public AlbumServiceImpl( AlbumRepository albumRepository ) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void add(Album entity) {
        this.albumRepository.save(entity);
    }

    @Override
    public void update(Album entity) {

    }

    @Override
    public Album delete(Long aLong) {
        Optional<Album> albumOptional = albumRepository.findById(aLong);
        albumOptional.ifPresent(this.albumRepository::delete);
        return albumOptional.orElseThrow();
    }

    @Override
    public Album getById(Long aLong) {
        Optional<Album> albumOptional = albumRepository.findById(aLong);
        return albumOptional.
                orElseThrow();
    }

    @Override
    public List<Album> getAll() {
        List<Album> albums = this.albumRepository.findAll();
        return albums
                .stream()
                .toList();
    }
}
