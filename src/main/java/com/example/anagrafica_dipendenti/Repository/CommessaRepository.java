package com.example.anagrafica_dipendenti.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Commessa;

@Repository
public interface CommessaRepository extends JpaRepository<Commessa,Long> {
    List<Commessa> findByDipendenti_Id(Long dipendentiId);
    List<Commessa> findByResponsabile_Id(Long responsabileId);
    
}
