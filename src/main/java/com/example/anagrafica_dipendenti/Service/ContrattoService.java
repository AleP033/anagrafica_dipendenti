package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    /*  Metodo: riceve l'id di un dipentente e un nuovo contratto,cerca il dipendente nel DB
        se non trova da errore,se lo trova collega il contratto al dipendente e lo salva nel DB
    */
    public Contratto createForDipendente(Long dipendenteId, Contratto c) {
        Dipendente d = dipendenteRepository.findById(dipendenteId)
        .orElseThrow(()-> new RuntimeException("Dipendente non trovato"));
        c.setDipendente(d);
        return contrattoRepository.save(c);
    }
    /*Metodo: riceve l'Id di un dipendente,usa il repository per cercare 
    tutti i contratti di quel dipendente,li mette in una lista
     */
    public List<Contratto> findByDipendente(Long dipendente_Id) {
        return contrattoRepository.findByDipendente_Id(dipendente_Id);
    }

    
}
