package com.example.anagrafica_dipendenti.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Commessa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String descrizione;
    private String dataInizio;
    private String dataFine;
    private Float importo;

    @ManyToMany(mappedBy = "commesse")
    private Set<Dipendente> dipendenti = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "responsabile_id")
    private Responsabile responsabile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

    public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(Set<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
   
    

    
}
