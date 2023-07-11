package fr.cindanojonathan.departementservice.mapper;

import fr.cindanojonathan.departementservice.dto.DepartmentDto;
import fr.cindanojonathan.departementservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
