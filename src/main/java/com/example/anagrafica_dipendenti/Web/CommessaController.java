package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.CommessaDTO;
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
    public CommessaDTO insert(@RequestBody CommessaDTO c ) {
        return commessaService.insert(c);
    }

    //Lista con tutte le commesse
    @GetMapping
    public List<CommessaDTO> getAll() {
        return commessaService.getAll();
    }


    //Cerco una commessa per Id
    @GetMapping("/{id}")
    public CommessaDTO getById(@PathVariable Long Id) {
        return commessaService.getById(Id);
    }

    //Aggiungo una commessa al dipendente
   @PostMapping("/{commessaId}/dipendente/{dipendenteId}")
public String addToDipendente(@PathVariable Long commessaId, @PathVariable Long dipendenteId) {
    commessaService.addDipendente(dipendenteId, commessaId);
    return "Dipendente aggiunto alla commessa";
}

//Aggiungo una commessa al responsabil
@PostMapping("/{commessaId}/responsabile/{responsabileId}")
public String addToResponsabile(@PathVariable Long commessaId, @PathVariable Long responsabileId)  {
    commessaService.addResponsabile(responsabileId, commessaId);
    return "Responsabile assegnato alla commessa";
}

// Restituisce una lista delle commesse associate al dipendente
    @GetMapping("/dipendente/{dipendenteId}")
    public List<CommessaDTO> getByDipendente(@PathVariable Long dipendenteId) {
        return commessaService.findByDipendente(dipendenteId);
    }

    // Restituisce una lista delle commesse associate al responsabile
    @GetMapping("/responsabile/{responsabileId}")
    public List<CommessaDTO> getByResponsabile(@PathVariable Long responsabileId) {
        return commessaService.findByResponsabile(responsabileId);
    }



    
}
