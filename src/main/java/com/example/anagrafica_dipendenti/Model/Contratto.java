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
    private Dipendente dipendenti;

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
    public String getDataInizio(){
        return dataInizio;
    }
    public void setDataInizio(String DataInizio){
        this.dataInizio = DataInizio;
    }
    public String getDataFine(){
        return dataFine;
    }
    public void setDataFine(String DataFine){
        this.dataFine = DataFine;
    }
    public Dipendente getDipendenti(){
        return dipendenti;
    }
    public void setDipendente(Dipendente dipendenti){
        this.dipendenti = dipendenti;
    }
  
    
    
}
