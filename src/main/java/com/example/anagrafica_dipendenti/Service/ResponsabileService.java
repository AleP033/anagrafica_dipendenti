package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.anagrafica_dipendenti.Dto.ResponsabileDTO;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Model.Responsabile;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import com.example.anagrafica_dipendenti.Repository.ResponsabileRepository;

@Service
public class ResponsabileService {
    private final ResponsabileRepository responsabileRepository;
    private final DipendenteRepository dipendenteRepository;




    // Costruttore
    public ResponsabileService(ResponsabileRepository responsabileRepository,
                               DipendenteRepository dipendenteRepository) {
            this.responsabileRepository = responsabileRepository;
            this.dipendenteRepository = dipendenteRepository;

    }
    // Crezione nuovo responsabile trasformo l'entità nel dto
    public ResponsabileDTO create (ResponsabileDTO r) {
        Responsabile responsabile = new Responsabile();
        responsabile.setNome(r.getNom());
        responsabile.setCognome(r.getCog());
        responsabile.setEmail(r.getEmail());
        responsabile.setData_inizio(r.getDatIni());
        responsabile.setData_fine(r.getDatFin());
        
        Responsabile saved = responsabileRepository.save(responsabile);
        return toDTO(saved);
    }
    // Trovo tutti i responsabili
       public List<ResponsabileDTO> getAll() {
    return responsabileRepository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
}
    // Trovo un responsabile per Id
   public ResponsabileDTO getById(Long id) 
{ 
   Responsabile r = responsabileRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Responsabile non trovato"));

    return toDTO(r); 
}
    // Associo un dipendente ad un responsabile
    public void addDipendente(Long responsabileId, Long dipendenteId) {
        Responsabile r = responsabileRepository.findById(responsabileId)
        .orElseThrow(()-> new RuntimeException("Responsabile non trovato"));
        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(()-> new RuntimeException("Dipendente non trovato"));

        r.getDipendenti().add(d); // aggiunge il dipendente alla lista del responsabile
        responsabileRepository.save(r); // salva
    }

    // Passo dall'entity al DTO
    private ResponsabileDTO toDTO(Responsabile r) {

        ResponsabileDTO dto = new ResponsabileDTO();

        dto.setId(r.getId());
        dto.setNom(r.getNome());
        dto.setCog(r.getCognome());
        dto.setEmail(r.getEmail());
        dto.setDatIni(r.getData_inizio());
        dto.setDatFin(r.getData_fine());

        // LISTE DI ID
        dto.setDipRIF(
            r.getDipendenti().stream()
                .map(d -> d.getId())
                .toList()
        );

        dto.setComRIF(
            r.getCommesse().stream()
                .map(c -> c.getId())
                .toList()
        );


        return dto;
    }
    
}
