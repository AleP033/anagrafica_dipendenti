package com.example.anagrafica_dipendenti.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.anagrafica_dipendenti.Dto.DipendenteDTO;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Model.Responsabile;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import com.example.anagrafica_dipendenti.Repository.ResponsabileRepository;



@Service
public class DipendenteService {
    
    private final DipendenteRepository dipendenteRepository;
    private final PasswordEncoder passwordEncoder;

@Autowired
private ResponsabileRepository responsabileRepository; 




    
    //Dependency injection via costruttore:
    public DipendenteService(DipendenteRepository dipendenteRepository, PasswordEncoder passwordEncoder) {
        this.dipendenteRepository = dipendenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //CREATE
   public DipendenteDTO insert(DipendenteDTO dto) {
    try {
    Dipendente d = new Dipendente();
    d.setNome(dto.getNome());
    d.setCognome(dto.getCognome());
    d.setEmail(dto.getEmail());
    d.setPassword(passwordEncoder.encode(dto.getPassword()));

    
    Dipendente saved = dipendenteRepository.save(d);

    return toDTO(saved);
     } catch (Exception e) {
        throw new RuntimeException("Errore nell'inserimento del dipendente");
    }
}

public DipendenteDTO addResponsabile(Long dipendenteId, Long responsabileId) {
try {
    Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

    Responsabile r = responsabileRepository.findById(responsabileId)
        .orElseThrow(() -> new RuntimeException("Responsabile non trovato"));

    d.getResponsabili().add(r);

    dipendenteRepository.save(d);

    return toDTO(d);
    } catch (Exception e) {
    throw new RuntimeException("Errore durante l'associazione del responsabile al dipendente");
}
}



    //READ(tutti)
    public List<DipendenteDTO> getAll() {
    return dipendenteRepository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
}

    //READ(per nome)
    public DipendenteDTO findByNome(String nome) {
        Dipendente d = dipendenteRepository.findByNome(nome);
        return toDTO(d);
    }

    // READ (per Id)
   public DipendenteDTO getById(Long id) { 
    Dipendente d = dipendenteRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

    return toDTO(d); 
}

     // Passo dall'entity al DTO
    private DipendenteDTO toDTO(Dipendente d) {
        try {
        DipendenteDTO dto = new DipendenteDTO();

        dto.setId(d.getId());
        dto.setNome(d.getNome());
        dto.setCognome(d.getCognome());
        dto.setEmail(d.getEmail());
        dto.setPassword(d.getPassword());

        // LISTE DI ID
        dto.setRespRIF(
            d.getResponsabili().stream()
                .map(r -> r.getId())
                .toList()
        );

        dto.setContrRIF(
            d.getContratti().stream()
                .map(c -> c.getId())
                .toList()
        );

        dto.setComRIF(
            d.getCommesse().stream()
                .map(c -> c.getId())
                .toList()
        );

        dto.setTimRIF(
            d.getTimesheets().stream()
                .map(t -> t.getId())
                .toList()
        );

        return dto;
         } catch (Exception e) {
            throw new RuntimeException("Errore durante la creazione del DTO");
        }
    }
}

