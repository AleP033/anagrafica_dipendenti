package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    // Crezione nuovo responsabile
    public Responsabile create (Responsabile r) {
        return responsabileRepository.save(r);
    }
    // Trovo tutti i responsabili
    public List<Responsabile> findAll(){
        return responsabileRepository.findAll();
    }
    // Trovo un responsabile per Id
    public Responsabile findById(Long id){
        return (Responsabile) responsabileRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Responsabile non trovato"));
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

    
}
