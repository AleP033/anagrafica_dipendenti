package com.example.anagrafica_dipendenti.Dto;

public class ContrattoDTO {

     private Long id;
    private String tip;
    private String datIni;
    private String datFin;

    private Long dipRIF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDatIni() {
        return datIni;
    }

    public void setDatIni(String datIni) {
        this.datIni = datIni;
    }

    public String getDatFin() {
        return datFin;
    }

    public void setDatFin(String datFin) {
        this.datFin = datFin;
    }

    public Long getDipRIF() {
        return dipRIF;
    }

    public void setDipRIF(Long dipRIF) {
        this.dipRIF = dipRIF;
    }
    

    
}
