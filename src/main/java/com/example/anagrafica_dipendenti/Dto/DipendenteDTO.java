package com.example.anagrafica_dipendenti.Dto;

import java.util.List;

public class DipendenteDTO {

  private Long id;
  private String nome;
  private String cognome;
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
