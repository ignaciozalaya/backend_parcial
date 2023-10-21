package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.InvoiceItem;
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}