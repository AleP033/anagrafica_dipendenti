package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

 //GET tutti
 public List<Timesheet> findAll(){
    return timesheetRepository.findAll();
 }

 //POST
 public Timesheet insert(Timesheet t) {
    return timesheetRepository.save(t);
 }

 //GET ID
 public Timesheet findById(Long id){
    return timesheetRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Timesheet non trovato"));
 }

 // Associo un timesheet al dipendente
 public Timesheet addDipendente(Long dipendenteId, Long timesheetId) {
    Timesheet t = timesheetRepository.findById(timesheetId)
    .orElseThrow(()-> new RuntimeException("Timesheet non trovato"));
    Dipendente d = dipendenteRepository.findById(dipendenteId)
    .orElseThrow(()-> new RuntimeException("Dipendente non trovato"));

    // Associo il dipendente
    t.setDipendente(d);
    //Aggiorno la lista del dipendente,da aggiustare
    //d.getTimesheets().add(d);

    return timesheetRepository.save(t);
 }

 //Associo un timesheet alla commessa
 public Timesheet addCommessa(Long commessaId, Long timesheetId) {
    Timesheet t = timesheetRepository.findById(timesheetId)
    .orElseThrow(()-> new RuntimeException("Timesheet non trovato"));
    Commessa c = commessaRepository.findById(commessaId)
    .orElseThrow(()-> new RuntimeException("Commessa non trovata"));

    t.setCommessa(c);
    c.getTimesheets().add(t);

    return timesheetRepository.save(t);
 }




}




