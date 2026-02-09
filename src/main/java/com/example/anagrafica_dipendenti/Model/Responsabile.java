package com.example.anagrafica_dipendenti.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Responsabile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataInizio;
    private LocalDate dataFine;

   
    @ManyToMany(mappedBy= "responsabili")
    private Set<Dipendente> dipendenti = new HashSet<>();

    @OneToMany(mappedBy = "responsabile")
     @JsonIgnore
    private List<Commessa> commesse = new ArrayList<>();


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
  public LocalDate getData_inizio(){
    return dataInizio;
  }
  public void setData_inizio(LocalDate Data_inizio){
    this.dataInizio = Data_inizio;
  }
  public LocalDate getData_fine(){
    return dataFine;
  }
  public void setData_fine(LocalDate Data_fine){
    this.dataFine = Data_fine;
  }
 public Set<Dipendente> getDipendenti(){
    return dipendenti;
}
  public void setDipendenti(Set<Dipendente> dipendenti){
    this.dipendenti = dipendenti;
}
  public LocalDate getDataInizio() {
    return dataInizio;
  }
  public void setDataInizio(LocalDate dataInizio) {
    this.dataInizio = dataInizio;
  }
  public LocalDate getDataFine() {
    return dataFine;
  }
  public void setDataFine(LocalDate dataFine) {
    this.dataFine = dataFine;
  }
  public List<Commessa> getCommesse() {
    return commesse;
  }
  public void setCommesse(List<Commessa> commesse) {
    this.commesse = commesse;
  }



    
}
