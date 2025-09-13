package rh.service.RH.Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testConnection")
public class TestConnection {
    @GetMapping
    public String testeConexao() {
        return "Olá Mundo!";
    }
}
