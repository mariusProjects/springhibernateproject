package com.sda.validator;

import com.sda.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    public boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }
        if (name.isEmpty()) {
            return false;
        }
        if (!name.matches("([A-Z a-z])*")) {
            return false;
        }
        return true;
    }

    public boolean isAgeValid(Integer age) {
        if (age == null) {
            return false;
        }

        if (age < 18 || age > 100) {
            return false;
        }
        return true;
    }

    public boolean isPositionValid(String position) {
        if (position == null) {
            return false;
        }
        if (position.isEmpty()) {
            return false;
        }
        if (!position.matches("([A-Z a-z])*")) {
            return false;
        }
        return true;
    }

    public boolean isDTOValid(EmployeeDTO employeeDTO) {
        if (isNameValid(employeeDTO.getNameOfEmployee()) && isPositionValid(employeeDTO.getPosition()) && isAgeValid(employeeDTO.getAge())) {
            return true;
        }
        return false;
    }
}
