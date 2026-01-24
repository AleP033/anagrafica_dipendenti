package com.example.anagrafica_dipendenti.Dto;



public class TimesheetDTO {

    private Long id;
    private String oreLav;
    private String dat;
    private String tip;
    
    private Long dipRIF;
    private Long comRIF;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOreLav() {
        return oreLav;
    }
    public void setOreLav(String oreLav) {
        this.oreLav = oreLav;
    }
    public String getDat() {
        return dat;
    }
    public void setDat(String dat) {
        this.dat = dat;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
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
