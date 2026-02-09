package com.example.anagrafica_dipendenti.Dto;

import java.time.LocalDate;
import java.util.List;

public class ResponsabileDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate datInizio;
    private LocalDate datFine;

    private List<Long> dipRIF;
    private List<Long> comRIF;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public List<Long> getDipRIF() {
        return dipRIF;
    }
    public void setDipRIF(List<Long> dipRIF) {
        this.dipRIF = dipRIF;
    }
    public List<Long> getComRIF() {
        return comRIF;
    }
    public void setComRIF(List<Long> comRIF) {
        this.comRIF = comRIF;
    }
    

    
}
