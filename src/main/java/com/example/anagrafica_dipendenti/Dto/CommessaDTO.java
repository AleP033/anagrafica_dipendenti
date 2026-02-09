package com.example.anagrafica_dipendenti.Dto;

import java.time.LocalDate;
import java.util.List;



public class CommessaDTO {

    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate datInizio;
    private LocalDate datFine;
    private Double importo;

    private List<Long> dipRIF;
    private Long respRIF;
    private List<Long> timRIF;


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
    public Double getImporto() {
        return importo;
    }
    public void setImporto(Double importo) {
        this.importo = importo
        ;
    }
    public List<Long> getDipRIF() {
        return dipRIF;
    }
    public void setDipRIF(List<Long> dipRIF) {
        this.dipRIF = dipRIF;
    }
    public List<Long> getTimRIF() {
        return timRIF;
    }
    public void setTimRIF(List<Long> timRIF) {
        this.timRIF = timRIF;
    }
    public Long getRespRIF() {
        return respRIF;
    }
    public void setRespRIF(Long respRIF) {
        this.respRIF = respRIF;
    } 
    

    
    
}
