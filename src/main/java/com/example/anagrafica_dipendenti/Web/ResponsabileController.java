package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.ResponsabileDTO;
import com.example.anagrafica_dipendenti.Service.ResponsabileService;

@RestController
@RequestMapping("/responsabili")
//Dependency Injection/costruttore che richiama i metodi dal service
public class ResponsabileController {
    private final ResponsabileService responsabileService;
    public ResponsabileController(ResponsabileService responsabileService){
        this.responsabileService = responsabileService;
    }

    // Restituisce una lista con tutti i responsabili
    @GetMapping
    public List<ResponsabileDTO> getAll(){
        return responsabileService.getAll();
    }

    @GetMapping("/{id}")
     public ResponsabileDTO getById(@PathVariable Long id) { 
        return responsabileService.getById(id); 
    }

    // Crea un nuovo responsabile
    @PostMapping
    public ResponsabileDTO create(@RequestBody ResponsabileDTO r) {
        return responsabileService.create(r);
    }

    // Aggiunge un dipendente ad un responsabile
    @PostMapping("/{responsabileId}/dipendenti/{dipendenteId}")
    public void addDipendente(@PathVariable Long responsabileId, @PathVariable Long dipendenteId) {
        responsabileService.addDipendente(responsabileId, dipendenteId);
    
    }
    
}
