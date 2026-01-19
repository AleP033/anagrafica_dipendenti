package com.example.anagrafica_dipendenti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anagrafica_dipendenti.Model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet,Long>{
    List<Timesheet> findByDipendente_Id(Long dipendenteId);
    
}
