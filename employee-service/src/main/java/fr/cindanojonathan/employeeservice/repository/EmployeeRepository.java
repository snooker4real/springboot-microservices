package fr.cindanojonathan.employeeservice.repository;

import fr.cindanojonathan.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
