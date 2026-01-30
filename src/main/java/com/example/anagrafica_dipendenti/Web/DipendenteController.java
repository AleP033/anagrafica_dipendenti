package com.example.anagrafica_dipendenti.Web;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.DipendenteDTO;
import com.example.anagrafica_dipendenti.Dto.LoginRequest;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping 
    public List<DipendenteDTO> getAll() { 
         return dipendenteService.getAll(); 
}

    // Inserimento del dipendente
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public DipendenteDTO insert(@RequestBody DipendenteDTO d){
        return dipendenteService.insert(d);
    }

    //Aggiunge un responsabile
    @PostMapping("/{dipendenteId}/responsabili/{responsabileId}")
    public DipendenteDTO addResponsabile(@PathVariable Long dipendenteId,@PathVariable Long responsabileId) {
    return dipendenteService.addResponsabile(dipendenteId, responsabileId);
}


    //Mappa richieste del tipo dipendenti/1
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public DipendenteDTO getById(@PathVariable Long id) { 
          return dipendenteService.getById(id); 
}

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/doLogin")
    public DipendenteDTO login(@RequestBody LoginRequest request) {
           return dipendenteService.login(request.getEmail(), request.getPassword());
}


    
}
