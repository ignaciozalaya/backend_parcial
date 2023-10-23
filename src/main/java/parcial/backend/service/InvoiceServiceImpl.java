package parcial.backend.service;

import parcial.backend.entities.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService{
    @Override
    public List<Invoice> findAll() {
        return null;
    }

    @Override
    public Optional<Invoice> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
