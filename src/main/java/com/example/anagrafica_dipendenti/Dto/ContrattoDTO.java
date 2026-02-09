package com.example.anagrafica_dipendenti.Dto;

import java.time.LocalDate;

public class ContrattoDTO {

     private Long id;
    private String tipo;
    private LocalDate datInizio;
    private LocalDate datFine;

    private Long dipRIF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDatInizio() {
        return datInizio;
    }

    public void setDatInizio(LocalDate datInizio) {
        this.datInizio = datInizio;
    }

    public LocalDate getDatFine() {
        return datFine;
    }

    public void setDatFine(LocalDate datFine) {
        this.datFine = datFine;
    }

    public Long getDipRIF() {
        return dipRIF;
    }

    public void setDipRIF(Long dipRIF) {
        this.dipRIF = dipRIF;
    }
    

    
}
