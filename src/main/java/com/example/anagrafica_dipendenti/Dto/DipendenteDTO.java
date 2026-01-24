package com.example.anagrafica_dipendenti.Dto;

import java.util.List;

public class DipendenteDTO {

  private Long id;
  private String nom;
  private String cog;
  private String email;
  private String password;

  private List<Long> respRIF;
  private List<Long> contrRIF;
  private List<Long> comRIF;
  private List<Long> timRIF;


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
  
  public List<Long> getRespRIF() {
    return respRIF;
  }
  public void setRespRIF(List<Long> respRIF) {
    this.respRIF = respRIF;
  }
  public List<Long> getContrRIF() {
    return contrRIF;
  }
  public void setContrRIF(List<Long> contrRIF) {
    this.contrRIF = contrRIF;
  }
  public List<Long> getComRIF() {
    return comRIF;
  }
  public void setComRIF(List<Long> comRIF) {
    this.comRIF = comRIF;
  }
  public List<Long> getTimRIF() {
    return timRIF;
  }
  public void setTimRIF(List<Long> timRIF) {
    this.timRIF = timRIF;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


}
