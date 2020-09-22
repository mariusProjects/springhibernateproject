package com.sda.dto;

public class ManagerDTO extends EmployeeDTO {

    private String departmentManager;

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManaged(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    @Override
    public String toString() {
        return "Managerul are numele: " + super.getNameOfEmployee() + " si ocupa pozitia "
                + super.getPosition() + " are varsta: " + super.getAge()
                + " si este managerul departamentului " + getDepartmentManager();
    }
}
