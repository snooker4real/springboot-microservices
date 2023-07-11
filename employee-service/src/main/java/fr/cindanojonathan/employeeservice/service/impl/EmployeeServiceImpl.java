package fr.cindanojonathan.employeeservice.service.impl;

import fr.cindanojonathan.employeeservice.dto.EmployeeDto;
import fr.cindanojonathan.employeeservice.entity.Employee;
import fr.cindanojonathan.employeeservice.exception.EmailAlreadyExistsException;
import fr.cindanojonathan.employeeservice.exception.ResourceNotFoundException;
import fr.cindanojonathan.employeeservice.mapper.AutoEmployeeMapper;
import fr.cindanojonathan.employeeservice.repository.EmployeeRepository;
import fr.cindanojonathan.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if(optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists For User");
        }

        Employee employee = AutoEmployeeMapper.EMPLOYEE_MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long userId) {

        Employee employee = employeeRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Employee" , "id", userId)
        );

//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        EmployeeDto employeeDto = AutoEmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
