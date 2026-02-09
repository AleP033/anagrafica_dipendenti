package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anagrafica_dipendenti.Dto.CommessaDTO;
import com.example.anagrafica_dipendenti.Model.Commessa;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Model.Responsabile;
import com.example.anagrafica_dipendenti.Repository.CommessaRepository;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import com.example.anagrafica_dipendenti.Repository.ResponsabileRepository;

@Service
public class CommessaService {

    private final CommessaRepository commessaRepository;
    private final DipendenteRepository dipendenteRepository;
    private final ResponsabileRepository responsabileRepository;

    @Autowired
    public CommessaService(CommessaRepository commessaRepository,
                           DipendenteRepository dipendenteRepository,
                           ResponsabileRepository responsabileRepository) {
        this.commessaRepository = commessaRepository;
        this.dipendenteRepository = dipendenteRepository;
        this.responsabileRepository = responsabileRepository;
    }

    //POST
     public CommessaDTO insert(CommessaDTO dto) {
    try {
    Commessa c = new Commessa();
    c.setTitolo(dto.getTitolo());
    c.setDescrizione(dto.getDescrizione());
    c.setDataInizio(dto.getDatInizio());
    c.setDataFine(dto.getDatFine());
    c.setImporto(dto.getImporto());
    

    Commessa saved = commessaRepository.save(c);

    return toDTO(saved);

    } catch (Exception e) {
        throw new RuntimeException("Errore durante l'inserimento della commessa", e);
    }
}

    //GET tutti
    public List<CommessaDTO> getAll() {
     return commessaRepository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
}

    //GET per id
   public CommessaDTO getById(Long id) { 
    Commessa c = commessaRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Commessa non trovata"));

    return toDTO(c);
}

    //Associo un dipendente ad una commessa
    public Commessa addDipendente(Long dipendenteId, Long commessaId) {
        try {
        Commessa c = commessaRepository.findById(commessaId)
        .orElseThrow(() -> new RuntimeException("Commessa non trovata"));

        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        c.getDipendenti().add(d);
        d.getCommesse().add(c);

        dipendenteRepository.save(d);

        return commessaRepository.save(c);
             
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'associazione del dipendente alla commessa", e);
        }
    }

    //Associo un responsabile ad una commessa
    public Commessa addResponsabile(Long responsabileId, Long commessaId){
        try {
        Commessa c = commessaRepository.findById(commessaId).
        orElseThrow(() -> new RuntimeException("Commessa non trovata"));

        Responsabile r = responsabileRepository.findById(responsabileId).
        orElseThrow(() -> new RuntimeException("Responsabile non trovato"));

        c.setResponsabile(r);
        return commessaRepository.save(c);
         } catch (Exception e) {
            throw new RuntimeException("Errore durante l'associazione del responsabile alla commessa", e);
        }
    }

    // converto da entity a DTO perchè non funzionava il find
    public List<CommessaDTO> findByDipendente(Long dipendente_Id) {
        return commessaRepository.findByDipendenti_Id(dipendente_Id)
        .stream()
        .map(this::toDTO)
        .toList();
    }


    public List<CommessaDTO> findByResponsabile(Long responsabile_Id) {
        return commessaRepository.findByResponsabile_Id(responsabile_Id)
        .stream()
        .map(this::toDTO)
        .toList();
    }

    // Passo dall'entity al DTO
    private CommessaDTO toDTO(Commessa c) {
    try {
        CommessaDTO dto = new CommessaDTO();

        dto.setId(c.getId());
        dto.setTitolo(c.getTitolo());
        dto.setDescrizione(c.getDescrizione());
        dto.setDatInizio(c.getDataInizio());
        dto.setDatFine(c.getDataFine());
        dto.setImporto(c.getImporto());
       
        if (c.getResponsabile() != null) { 
            dto.setRespRIF(c.getResponsabile().getId()); 
        }

        // LISTE DI ID
        dto.setDipRIF(
            c.getDipendenti().stream()
                .map(d -> d.getId())
                .toList()
        );
        
        dto.setTimRIF(
            c.getTimesheets().stream()
                .map(t -> t.getId())
                .toList()
        );

        return dto;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la creazione del DTO", e);
    }
    }

}
