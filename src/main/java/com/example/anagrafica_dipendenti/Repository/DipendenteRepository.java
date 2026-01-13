package com.example.anagrafica_dipendenti.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {
    Dipendente findByNome(String nome);

// Metodo login
Optional<Dipendente> findByEmail(String email);

    

}
