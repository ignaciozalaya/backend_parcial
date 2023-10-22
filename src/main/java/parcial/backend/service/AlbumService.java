package parcial.backend.service;

import parcial.backend.entities.Album;

import java.util.List;

public interface AlbumService {
    Album create(String title, String artistName);
    public List<Album> getAll();
    public Album   getById(Integer id);

}
