package com.example.anagrafica_dipendenti.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String oreLavorate;
    private String data;
    private String tipologia;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "commessa_id")
    @JsonIgnore
    private Commessa commessa;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOreLavorate() {
        return oreLavorate;
    }

    public void setOreLavorate(String oreLavorate) {
        this.oreLavorate = oreLavorate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Commessa getCommessa() {
        return commessa;
    }

    public void setCommessa(Commessa commessa) {
        this.commessa = commessa;
    }

    
    
}
