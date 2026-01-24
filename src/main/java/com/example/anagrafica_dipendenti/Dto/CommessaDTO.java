package com.example.anagrafica_dipendenti.Dto;

import java.util.List;



public class CommessaDTO {

    private Long id;
    private String tit;
    private String des;
    private String datIni;
    private String datFin;
    private Float imp;

    private List<Long> dipRIF;
    private Long respRIF;
    private List<Long> timRIF;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTit() {
        return tit;
    }
    public void setTit(String tit) {
        this.tit = tit;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
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
    public Float getImp() {
        return imp;
    }
    public void setImp(Float imp) {
        this.imp = imp;
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
