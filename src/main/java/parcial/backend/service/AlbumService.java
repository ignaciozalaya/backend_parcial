package parcial.backend.service;

import parcial.backend.entities.Album;

import java.util.List;

public interface AlbumService {
    Album create(String title, String artistName);
    List<Album> findAll();
    public Album   getById(Integer id);

}
