package fr.cindanojonathan.departementservice.service;

import fr.cindanojonathan.departementservice.dto.DepartmentDto;
import fr.cindanojonathan.departementservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
