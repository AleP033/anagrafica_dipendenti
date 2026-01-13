package com.example.anagrafica_dipendenti.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.LoginRequest;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Service.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    private final DipendenteService dipendenteService;
// Dependency Injection tramite costruttore
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    // Ritorna una lista con tutti i dipendenti
    @GetMapping
    public List<Dipendente> getAll() {
        return dipendenteService.findAll();
    } 

    // Inserimento del dipendente
    @PostMapping
    public Long insert(@RequestBody Dipendente d){
        return dipendenteService.insert(d);
    }

    //Mappa richieste del tipo dipendenti/1,opzionale
    @GetMapping("/{id}")
    public Optional<Dipendente> getById(@PathVariable Long id){
        return dipendenteService.findById(id);

    }

    @PostMapping("/doLogin")
public Dipendente login(@RequestBody LoginRequest request) {
    return dipendenteService.login(request.getEmail(), request.getPassword());
}


    
}
