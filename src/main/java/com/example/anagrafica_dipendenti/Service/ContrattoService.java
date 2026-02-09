package com.example.anagrafica_dipendenti.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.anagrafica_dipendenti.Dto.ContrattoDTO;
import com.example.anagrafica_dipendenti.Model.Contratto;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Repository.ContrattoRepository;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;

@Service
public class ContrattoService {
    private final ContrattoRepository contrattoRepository;
    private final DipendenteRepository dipendenteRepository;
// Costruttore
    public ContrattoService(ContrattoRepository contrattoRepository,
                            DipendenteRepository dipendenteRepository) {
        this.contrattoRepository = contrattoRepository;
        this.dipendenteRepository = dipendenteRepository;
    }
  // CREATE con DTO 
  public ContrattoDTO create(ContrattoDTO dto) { 
    try {
    Contratto c = new Contratto(); 
    c.setTipo(dto.getTipo()); 
    c.setDataInizio(dto.getDatInizio()); 
    c.setDataFine(dto.getDatFine()); 
    if (dto.getDipRIF() != null) { 
        Dipendente d = dipendenteRepository.findById(dto.getDipRIF()) 
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato")); 
        c.setDipendente(d); 
    } 
    Contratto saved = contrattoRepository.save(c); 
    return toDTO(saved); 
     } catch (Exception e) {
        throw new RuntimeException("Errore nell'inserimento del contratto");
    }
}

 //Associo un dipendente ad un contratto
    public Contratto addDipendente(Long dipendenteId, Long contrattoId) {
        try {
        Contratto c = contrattoRepository.findById(contrattoId)
        .orElseThrow(() -> new RuntimeException("Contratto non trovato"));

        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

     
        d.getContratti().add(c); // perchè il dipendente può avere più contratti
        c.setDipendente(d);
        dipendenteRepository.save(d);
        contrattoRepository.save(c);

        return c;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'associazione del dipendente al contratto", e);
        }
    }

    public List<ContrattoDTO> findAll() {
    return contrattoRepository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
    }

   // READ: tutti i contratti di un dipendente 
   public List<ContrattoDTO> findByDipendenti(Long dipendenteId) {
     return contrattoRepository.findByDipendenti_Id(dipendenteId).stream()
     .map(this::toDTO)
     .toList(); 
    }
      // MAPPER ENTITY → DTO 
      private ContrattoDTO toDTO(Contratto c) { 
        try {
        ContrattoDTO dto = new ContrattoDTO(); 
        dto.setId(c.getId()); 
        dto.setTipo(c.getTipo()); 
        dto.setDatInizio(c.getDataInizio()); 
        dto.setDatFine(c.getDataFine()); 
        if (c.getDipendenti() != null) { 
            dto.setDipRIF(c.getDipendenti().getId()); 
        } 
        return dto; 
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la creazione del DTO", e);
        }
    }
    /*  Metodo: riceve l'id di un dipentente e un nuovo contratto,cerca il dipendente nel DB
        se non trova da errore,se lo trova collega il contratto al dipendente e lo salva nel DB
    */
   /*  public Contratto createForDipendente(Long dipendenteId, Contratto c) {
        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(()-> new RuntimeException("Dipendente non trovato"));
        c.setDipendente(d);
        return contrattoRepository.save(c);
    }
    */
    /*Metodo: riceve l'Id di un dipendente,usa il repository per cercare 
    tutti i contratti di quel dipendente,li mette in una lista
     */
   /*  public List<Contratto> findByDipendente(Long dipendente_Id) {
        return contrattoRepository.findByDipendenti_Id(dipendente_Id);
    }
    */
    
}

