package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anagrafica_dipendenti.Dto.TimesheetDTO;
import com.example.anagrafica_dipendenti.Model.Commessa;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Model.Timesheet;
import com.example.anagrafica_dipendenti.Repository.CommessaRepository;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import com.example.anagrafica_dipendenti.Repository.TimesheetRepository;

@Service
public class TimesheetService {
    private final TimesheetRepository timesheetRepository;
    private final CommessaRepository commessaRepository;
    private final DipendenteRepository dipendenteRepository;
    @Autowired
    public TimesheetService(TimesheetRepository timesheetRepository,
                            CommessaRepository commessaRepository,
                            DipendenteRepository dipendenteRepository) {
    this.timesheetRepository = timesheetRepository;
    this.commessaRepository = commessaRepository;
    this.dipendenteRepository = dipendenteRepository;
 }

     // Crezione nuovo timesheet trasformo l'entità nel dto
    public TimesheetDTO create (TimesheetDTO t) {
        Timesheet timesheet = new Timesheet();
        timesheet.setOreLavorate(t.getOreLav());
        timesheet.setData(t.getDat());
        timesheet.setTipologia(t.getTip());
        
        Timesheet saved = timesheetRepository.save(timesheet);
        return toDTO(saved);
    }

 //GET tutti
      public List<TimesheetDTO> getAll() {
    return timesheetRepository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
}
 //GET ID
    public TimesheetDTO getById(Long id) 
{ 
   Timesheet t = timesheetRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Timesheet non trovato"));

    return toDTO(t); 
}

 // Associo un timesheet al dipendente 
 public TimesheetDTO addDipendente(Long dipendenteId, Long timesheetId) { 
    Timesheet t = timesheetRepository.findById(timesheetId) 
    .orElseThrow(() -> new RuntimeException("Timesheet non trovato")); 
    Dipendente d = dipendenteRepository.findById(dipendenteId) 
    .orElseThrow(() -> new RuntimeException("Dipendente non trovato")); 
    
    t.setDipendente(d); 
    Timesheet saved = timesheetRepository.save(t); 
    return toDTO(saved); 
}

 //Associo un timesheet alla commessa
 public TimesheetDTO addCommessa(Long commessaId, Long timesheetId) {
    Timesheet t = timesheetRepository.findById(timesheetId)
    .orElseThrow(()-> new RuntimeException("Timesheet non trovato"));
    Commessa c = commessaRepository.findById(commessaId)
    .orElseThrow(()-> new RuntimeException("Commessa non trovata"));

    t.setCommessa(c);
    Timesheet saved = timesheetRepository.save(t);

    return toDTO(saved);
 }

  // Passo dall'entity al DTO
    private TimesheetDTO toDTO(Timesheet t) {

        TimesheetDTO dto = new TimesheetDTO();

        dto.setId(t.getId());
        dto.setOreLav(t.getOreLavorate());
        dto.setDat(t.getData());
        dto.setTip(t.getTipologia());
        if (t.getDipendente() != null) { 
            dto.setDipRIF(t.getDipendente().getId()); 
        } 
        if (t.getCommessa() != null) { 
            dto.setComRIF(t.getCommessa().getId()); 
        } 

        return dto;

}
}




