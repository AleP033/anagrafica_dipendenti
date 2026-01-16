package com.example.anagrafica_dipendenti.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {
    Dipendente findByNome(String nome);
    List<Dipendente> findByCommesse_id(Long commessaId);

// Metodo login
Optional<Dipendente> findByEmail(String email);

    

}
