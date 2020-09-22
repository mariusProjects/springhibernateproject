package com.sda.controller;

import com.sda.dto.DepartmentDTO;
import com.sda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentsController {
    @Autowired
    public DepartmentService departmentService;

    @RequestMapping("/departments")
    @ResponseBody // astea 2 annotari ne spune ca primeste reuest-ul si creaza un raspuns
    public ResponseEntity displayDepartments() {
        List<DepartmentDTO> departmentDTOList = departmentService.displayDepartmentsDTO();

        return new ResponseEntity(departmentDTOList, HttpStatus.OK); // trimite status 200
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/createDepartment")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO departmentDTO1 = departmentService.createDepartment(departmentDTO);
        return departmentDTO1;
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Integer id) {
        boolean isDeleted = departmentService.deleteDepartment(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
