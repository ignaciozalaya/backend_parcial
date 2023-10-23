package parcial.backend.service;

import java.util.List;
import java.util.Optional;

public interface Service <T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void delete(ID id);

}