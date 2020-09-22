package com.sda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @RequestMapping({"", "/", "/index"}) // face maparea dintre requestul din browser si resursa din aplicatie
    // / arata ca e prima pagina care se deschide cand accesam localhost
    public String getIndexPage() {
        return "index";
    }

}
