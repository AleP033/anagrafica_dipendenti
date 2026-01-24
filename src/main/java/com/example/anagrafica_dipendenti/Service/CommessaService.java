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

    Commessa c = new Commessa();
    c.setTitolo(dto.getTit());
    c.setDescrizione(dto.getDes());
    c.setDataInizio(dto.getDatIni());
    c.setDataFine(dto.getDatFin());
    c.setImporto(dto.getImp());
    

    Commessa saved = commessaRepository.save(c);

    return toDTO(saved);
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

        Commessa c = commessaRepository.findById(commessaId)
        .orElseThrow(() -> new RuntimeException("Commessa non trovata"));

        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        c.getDipendenti().add(d);
        d.getCommesse().add(c);

        dipendenteRepository.save(d);

        return c;
    }

    //Associo un responsabile ad una commessa
    public Commessa addResponsabile(Long responsabileId, Long commessaId){
        Commessa c = commessaRepository.findById(commessaId).
        orElseThrow(() -> new RuntimeException("Commessa non trovata"));

        Responsabile r = responsabileRepository.findById(responsabileId).
        orElseThrow(() -> new RuntimeException("Responsabile non trovato"));

        c.setResponsabile(r);
        return commessaRepository.save(c);
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

        CommessaDTO dto = new CommessaDTO();

        dto.setId(c.getId());
        dto.setTit(c.getTitolo());
        dto.setDes(c.getDescrizione());
        dto.setDatIni(c.getDataInizio());
        dto.setDatFin(c.getDataFine());
        dto.setImp(c.getImporto());
       
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
    }

}
