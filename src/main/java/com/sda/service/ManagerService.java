package com.sda.service;

import com.sda.dto.ManagerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    public List<ManagerDTO> displayManagers() {
        List<ManagerDTO> managerDTOList = new ArrayList<>();
        ManagerDTO managerDTO1 = new ManagerDTO();
        managerDTO1.setNameOfEmployee("Anton");
        managerDTO1.setDepartmentManaged("Marketing");
        managerDTO1.setPosition("Executive Manager");
        managerDTO1.setAge(33);

        ManagerDTO managerDTO2 = new ManagerDTO();
        managerDTO2.setNameOfEmployee("Rusu");
        managerDTO2.setDepartmentManaged("HR");
        managerDTO2.setPosition("Recruitment Manager");
        managerDTO2.setAge(40);

        ManagerDTO managerDTO3 = new ManagerDTO();
        managerDTO1.setNameOfEmployee("Maria");
        managerDTO1.setDepartmentManaged("Manager");
        managerDTO1.setPosition("Executive Manager");
        managerDTO1.setAge(53);

        managerDTOList.add(managerDTO1);
        managerDTOList.add(managerDTO2);
        managerDTOList.add(managerDTO3);

        return managerDTOList;
    }
}
