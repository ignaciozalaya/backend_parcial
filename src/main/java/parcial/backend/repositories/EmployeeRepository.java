package parcial.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.backend.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}