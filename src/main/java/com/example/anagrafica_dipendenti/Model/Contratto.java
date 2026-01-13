package com.example.anagrafica_dipendenti.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String dataInizio;
    private String dataFine;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    // getters and setters
    public Long getId(){
        return id;
    }
    public void setId(Long Id) {
        this.id = Id;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String Tipo){
        this.tipo = Tipo;
    }
    public String getData_inizio(){
        return dataInizio;
    }
    public void setData_inizio(String Data_inizio){
        this.dataInizio = Data_inizio;
    }
    public String getData_fine(){
        return dataFine;
    }
    public void setData_fine(String Data_fine){
        this.dataFine = Data_fine;
    }
    public Dipendente getDipendente(){
        return dipendente;
    }
    public void setDipendente(Dipendente dipendente){
        this.dipendente = dipendente;
    }
  
    
    
}
