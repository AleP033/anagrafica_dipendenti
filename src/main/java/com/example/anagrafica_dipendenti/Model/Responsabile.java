package com.example.anagrafica_dipendenti.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Responsabile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String dataInizio;
    private String dataFine;

    @JsonIgnore // ignora le proprietà della serializzazione/deserializzazione
    @ManyToMany(mappedBy= "responsabili")
    private Set<Dipendente> dipendenti = new HashSet<>();


    // getters and setters
  public Long getId() {
    return id;
  }
  public void setId(Long Id){
    this.id = Id;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String Nome){
    this.nome=Nome;
  }
  public String getCognome(){
    return cognome;
  }
  public void setCognome(String Cognome){
    this.cognome=Cognome;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String Email){
    this.email=Email;
  }
  public String getData_inizio(){
    return dataInizio;
  }
  public void setData_inizio(String Data_inizio){
    this.dataInizio = Data_inizio;
  }
  public String getData_fine(){
    return dataFine;
  }
  public void setData_fine(String Data_fine){
    this.dataFine = Data_fine;
  }
  public List<Dipendente> getDipendenti(){
    return (List<Dipendente>) dipendenti;
  }
  public void setDipendente(List<Dipendente> dipedenti){
    this.dipendenti = dipendenti;
  }
    
}
