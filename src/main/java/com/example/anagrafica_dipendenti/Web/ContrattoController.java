package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Dto.ContrattoDTO;
import com.example.anagrafica_dipendenti.Service.ContrattoService;

@RestController
@RequestMapping("/contratti")
// Dependency Injection/costruttore, il controller richiama la logica del service
public class ContrattoController {
    private final ContrattoService contrattoService;
    public ContrattoController(ContrattoService contrattoService) {
        this.contrattoService = contrattoService;
    }

    // Crea il contrattoDTO
    @PostMapping
    public ContrattoDTO create(@RequestBody ContrattoDTO dto){
        return contrattoService.create(dto);
    }

     //Aggiungo un contratto al dipendente
    @CrossOrigin(origins = "http://localhost:4200")
   @PostMapping("/{contrattoId}/dipendente/{dipendenteId}")
   public String addToDipendente(@PathVariable Long contrattoId, @PathVariable Long dipendenteId) {
    contrattoService.addDipendente(dipendenteId, contrattoId);
    return "Dipendente aggiunto al contratto";
}

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ContrattoDTO> getAll() {
        return contrattoService.findAll();
    }


    // Restituisce una lista dei contratti associati ad un dipendenteId
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dipendente/{dipendenteId}")
    public List<ContrattoDTO> getByDipendente(@PathVariable Long dipendenteId) {
        return contrattoService.findByDipendenti(dipendenteId);
    }
    

}
