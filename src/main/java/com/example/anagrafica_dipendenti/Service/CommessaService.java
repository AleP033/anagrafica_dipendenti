package com.example.anagrafica_dipendenti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Commessa insert(Commessa c) {
        return commessaRepository.save(c);
    }

    //GET tutti
    public List<Commessa> findAll() {
        return commessaRepository.findAll();
    }

    //GET per id
    public Commessa findById(Long id) {
        return commessaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Commessa non trovata"));
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

    public List<Commessa> findByDipendente(Long dipendente_Id) {
        return commessaRepository.findByDipendenti_Id(dipendente_Id);
    }


    public List<Commessa> findByResponsabile(Long responsabile_Id) {
        return commessaRepository.findByResponsabile_id(responsabile_Id);
    }

}
