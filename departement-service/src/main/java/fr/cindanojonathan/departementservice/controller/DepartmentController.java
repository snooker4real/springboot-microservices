package fr.cindanojonathan.departementservice.controller;

import fr.cindanojonathan.departementservice.dto.DepartmentDto;
import fr.cindanojonathan.departementservice.exception.ErrorDetails;
import fr.cindanojonathan.departementservice.exception.ResourceNotFoundException;
import fr.cindanojonathan.departementservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // build save department REST API
    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, CREATED);
    }

    // build get department by code REST API
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, OK);
    }

}
