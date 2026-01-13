package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Model.Contratto;
import com.example.anagrafica_dipendenti.Service.ContrattoService;

@RestController
@RequestMapping("/contratti")
// Dependency Injection/costruttore, il controller richiama la logica del service
public class ContrattoController {
    private final ContrattoService contrattoService;
    public ContrattoController(ContrattoService contrattoService) {
        this.contrattoService = contrattoService;
    }

    // Crea il contratto per il dipendente,restituisce il contratto in JSON
    @PostMapping("/dipendente/{dipendenteId}")
    public Contratto createForDipendente(@PathVariable Long dipendenteId, @RequestBody Contratto c){
        return contrattoService.createForDipendente(dipendenteId, c);
    }

    // Restituisce una lista dei contratti associati ad un dipendenteId
    @GetMapping("/dipendente/{dipendenteId}")
    public List<Contratto> getByDipendente(@PathVariable Long dipendenteId) {
        return contrattoService.findByDipendente(dipendenteId);
    }
    
}
