package com.sda.controller;

import com.sda.dto.EmployeeDTO;
import com.sda.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @RequestMapping("/employees")
    @ResponseBody
    public ResponseEntity displayEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTO();

        return new ResponseEntity(employeeDTOList, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/createEmployee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = employeeService.addEmployee(employeeDTO);
        return employeeDTO1;
    }

    @DeleteMapping("/deleteEmployee/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
        boolean isDeleted = employeeService.deleteEmployee(name);
        if (!isDeleted) {
            return new ResponseEntity<>("S-au gasit mai multi employees cu acest nume sau niciunul !!!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Stergere efectuata cu succes!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteEmployee/name/{name}/position/{position}")
    public ResponseEntity<String> deleteEmployeeByNameAndPosition(@PathVariable String name, @PathVariable String position) {
        boolean isDeleted = employeeService.deleteEmployeeByNameAndPosition(name, position);
        if (!isDeleted) {
            return new ResponseEntity<>("S-au gasit mai multi employees cu acest nume sau niciunul !!!", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Stergere efectuata cu succes!", HttpStatus.ACCEPTED);
        }
    }


    @GetMapping("/employees/{name}")
    public List<EmployeeDTO> displayEmployeeByName(@PathVariable String name) {
        System.out.println("Numele folosit la cautare este: " + name);
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeesDTOByName(name);
        return employeeDTOList;
    }

    @GetMapping("/employees/name/{name}/position/{position}")
    public List<EmployeeDTO> displayEmployeeByNameAndPosition(@PathVariable String name, @PathVariable String position) {
        System.out.println("Numele folosit la cautare este: " + name + " iar pozitia este " + position);
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTOByNameAndPosition(name, position);
        return employeeDTOList;
    }

    @PutMapping(path = "/updateEmployee/{name}", consumes = "application/json", produces = "application/json")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable String name) {
        System.out.println(name);
        System.out.println(employeeDTO.getPosition() + "  " + employeeDTO.getAge());
        EmployeeDTO employeeDTOUpdated = employeeService.updateEmployee(name, employeeDTO);
        return employeeDTOUpdated;
    }
}
