package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Model.Commessa;
import com.example.anagrafica_dipendenti.Service.CommessaService;

@RestController
@RequestMapping("/commesse")
public class CommessaController {
    private final CommessaService commessaService;
    public CommessaController(CommessaService commessaService){
        this.commessaService = commessaService;
    }

    //Inserisco una commessa
    @PostMapping
    public Commessa insert(@RequestBody Commessa c ) {
        return commessaService.insert(c);
    }

    //Lista con tutte le commesse
    @GetMapping
    public List<Commessa> getAll() {
        return commessaService.findAll();
    }


    //Cerco una commessa per Id
    @GetMapping("/{id}")
    public Commessa getById(@PathVariable Long Id) {
        return commessaService.findById(Id);
    }

    //Aggiungo una commessa al dipendente
   @PostMapping("/{commessaId}/dipendente/{dipendenteId}")
public String addToDipendente(@PathVariable Long commessaId, @PathVariable Long dipendenteId) {
    commessaService.addDipendente(dipendenteId, commessaId);
    return "Dipendente aggiunto alla commessa";
}

//Aggiungo una commessa al responsabile
@PostMapping("/{commessaId}/responsabile/{responsabileId}")
public String addToResponsabile(@PathVariable Long commessaId, @PathVariable Long responsabileId)  {
    commessaService.addResponsabile(responsabileId, commessaId);
    return "Responsabile assegnato alla commessa";
}

// Restituisce una lista delle commesse associate al dipendente
    @GetMapping("/dipendente/{dipendenteId}")
    public List<Commessa> getByDipendente(@PathVariable Long dipendenteId) {
        return commessaService.findByDipendente(dipendenteId);
    }

    // Restituisce una lista delle commesse associate al responsabile
    @GetMapping("/responsabile/{responsabileId}")
    public List<Commessa> getByResponsabile(@PathVariable Long responsabileId) {
        return commessaService.findByResponsabile(responsabileId);
    }



    
}
