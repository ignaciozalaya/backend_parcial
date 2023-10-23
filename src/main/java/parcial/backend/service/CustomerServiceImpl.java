package parcial.backend.service;

import org.springframework.stereotype.Service;
import parcial.backend.entities.Customer;
import parcial.backend.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
