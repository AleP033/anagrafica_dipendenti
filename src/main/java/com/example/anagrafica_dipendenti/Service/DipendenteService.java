package com.example.anagrafica_dipendenti.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class DipendenteService {
    
    private final DipendenteRepository dipendenteRepository;
@Autowired
private PasswordEncoder passwordEncoder; 
    
    //Dependency injection via costruttore:
    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    //CREATE
   public Long insert(Dipendente dipendente) {
    dipendente.setPassword(passwordEncoder.encode(dipendente.getPassword()));
    Dipendente saved = dipendenteRepository.save(dipendente);
    return saved.getId();
}


    //READ(tutti)
    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    //READ(per nome)
    public Dipendente findByNome(String nome) {
        return dipendenteRepository.findByNome(nome);
    }

    // READ OPZIONALE(per Id)
    public Optional<Dipendente> findById(Long id) {
        return dipendenteRepository.findById(id);   
    }

    public Dipendente login(String email, String password){
        Dipendente d = dipendenteRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Email non trovata"));
        // se la password non corrisponde a quella salvata
        if (!passwordEncoder.matches(password, d.getPassword())) {
            throw new RuntimeException("Password errata");
        }
        return d;   
        
            
    }
}
