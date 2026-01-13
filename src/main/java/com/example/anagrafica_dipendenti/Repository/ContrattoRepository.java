package com.example.anagrafica_dipendenti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Contratto;

@Repository
public interface ContrattoRepository extends JpaRepository<Contratto,Long> {
    List<Contratto> findByDipendente_Id(Long dipendente_Id);
    
}
