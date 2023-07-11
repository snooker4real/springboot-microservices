package fr.cindanojonathan.employeeservice.mapper;

import fr.cindanojonathan.employeeservice.dto.EmployeeDto;
import fr.cindanojonathan.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
