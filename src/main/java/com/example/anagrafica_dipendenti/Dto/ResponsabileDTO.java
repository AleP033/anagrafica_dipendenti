package com.example.anagrafica_dipendenti.Dto;

import java.util.List;

public class ResponsabileDTO {

    private Long id;
    private String nom;
    private String cog;
    private String email;
    private String datIni;
    private String datFin;

    private List<Long> dipRIF;
    private List<Long> comRIF;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCog() {
        return cog;
    }
    public void setCog(String cog) {
        this.cog = cog;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
