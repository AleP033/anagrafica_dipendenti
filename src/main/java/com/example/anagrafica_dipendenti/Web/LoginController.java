package com.example.anagrafica_dipendenti.Web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.DipendenteDTO;
import com.example.anagrafica_dipendenti.Dto.LoginRequest;
import com.example.anagrafica_dipendenti.Service.LoginService;

@RestController
@RequestMapping("/autenticazione")

public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public DipendenteDTO login(@RequestBody LoginRequest request) {
           return loginService.login(request.getEmail(), request.getPassword());
}
    
}
