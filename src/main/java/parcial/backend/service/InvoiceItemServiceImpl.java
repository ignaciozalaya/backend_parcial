package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.InvoiceItem;
import parcial.backend.service.InvoiceItemService;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Override
    public List<InvoiceItem> findAll() {
        return null;
    }

    @Override
    public Optional<InvoiceItem> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
