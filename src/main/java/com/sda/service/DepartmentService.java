package com.sda.service;

import com.sda.dto.DepartmentDTO;
import com.sda.entities.Department;
import com.sda.repo.DepartmentRepo;
import com.sda.transfer.DepartmentMapper;
import com.sda.validator.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentValidator departmentValidator;

    public List<DepartmentDTO> displayDepartmentsDTO() {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        List<Department> departmentList = departmentRepo.displayAllDepartments();

        for (Department department : departmentList) {
            departmentDTOList.add(departmentMapper.convertDepartmentToDepartmentDTO(department));
            System.out.println(department);
        }
        return departmentDTOList;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentDTO departmentDTO1 = null;
        if (departmentValidator.isDepartmentDTOValid(departmentDTO)) {
            Department department = departmentMapper.convertDepartmentDTOToDepartment(departmentDTO);

            Department department1 = departmentRepo.createDepartment(department);
            departmentDTO1 = departmentMapper.convertDepartmentToDepartmentDTO(department1);
        }
        return departmentDTO1;
    }

    public boolean deleteDepartment(Integer id) {
        boolean isDeleted = departmentRepo.deleteDepartment(id);
        if(isDeleted){
            System.out.println("Department was deleted!");
        }else {
            System.out.println("Department was not deleted!");
        }
        return isDeleted;
    }
}
