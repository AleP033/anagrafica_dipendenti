package com.example.anagrafica_dipendenti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Responsabile;

@Repository
public interface ResponsabileRepository extends JpaRepository<Responsabile,Long> {
    List<Responsabile> findByDipendente_Id(Long dipendente_Id);
    
}
