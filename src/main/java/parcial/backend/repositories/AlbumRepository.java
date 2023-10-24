package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Album;
import parcial.backend.entities.Artist;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Optional<Album> findByTitle(String title);
}