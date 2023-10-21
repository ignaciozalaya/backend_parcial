package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}