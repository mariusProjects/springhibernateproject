package com.sda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagersController {
    @RequestMapping("/managers")
    public String displayManagers(){
        return "Aici vom afisa managerii";
    }
}
