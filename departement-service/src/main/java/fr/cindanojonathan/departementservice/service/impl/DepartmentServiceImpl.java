package fr.cindanojonathan.departementservice.service.impl;

import fr.cindanojonathan.departementservice.dto.DepartmentDto;
import fr.cindanojonathan.departementservice.entity.Department;
import fr.cindanojonathan.departementservice.exception.DeptCodeAlreadyExistsException;
import fr.cindanojonathan.departementservice.exception.ResourceNotFoundException;
import fr.cindanojonathan.departementservice.mapper.AutoDepartmentMapper;
import fr.cindanojonathan.departementservice.repository.DepartmentRepository;
import fr.cindanojonathan.departementservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert DepartmentDto to Department jpa entity
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );

        Optional<Department> optionalEmployee = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());

        if(optionalEmployee.isPresent()) {
            throw new DeptCodeAlreadyExistsException("Dept code already exists");
        }

        Department department = AutoDepartmentMapper.DEPARTMENT_MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

         Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                 () -> new ResourceNotFoundException("Department" , "departmentCode", departmentCode)
         );
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        DepartmentDto departmentDto = AutoDepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department);


        return departmentDto;
    }
}
