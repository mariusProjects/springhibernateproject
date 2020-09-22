package com.sda.validator;

import com.sda.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidator {
    public boolean isDepartmentNameValid(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isDepartmentDTOValid(DepartmentDTO departmentDTO) {
        if (!isDepartmentNameValid(departmentDTO.getNameOfDepartment())) {
            return false;
        }
        return true;
    }
}
