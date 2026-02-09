package com.example.anagrafica_dipendenti.Dto;

import java.time.LocalDate;

public class TimesheetDTO {

    private Long id;
    private String oreLavorate;
    private LocalDate dat;
    private String tipologia;
    
    private Long dipRIF;
    private Long comRIF;

    
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
    public LocalDate getDat() {
        return dat;
    }
    public void setDat(LocalDate dat) {
        this.dat = dat;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public Long getDipRIF() {
        return dipRIF;
    }
    public void setDipRIF(Long dipRIF) {
        this.dipRIF = dipRIF;
    }
    public Long getComRIF() {
        return comRIF;
    }
    public void setComRIF(Long comRIF) {
        this.comRIF = comRIF;
    }


    
}
