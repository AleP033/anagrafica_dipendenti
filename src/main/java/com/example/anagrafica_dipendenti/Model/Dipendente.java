package com.example.anagrafica_dipendenti.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

// Entity indica che la classe e' un entita' JPA
@Entity
/*  Posso usare anche table name ma se non scrivo niente 
la tabella verra' creata con il nome della classe(Dipendente)
*/
public class Dipendente{
  // @Id, indica la chiave primaria
     @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String cognome;
  private String email;
  private String password;


  @OneToMany
  @JoinColumn(name = "contratto_id")
  @JsonIgnore
  private List<Contratto> contratti = new ArrayList<>();

  
  @ManyToMany
  // ponte tra due tabelle
@JoinTable(
    name = "dipendente_responsabile",
    // FOREIGN KEY di questa classe
    joinColumns = @JoinColumn(name = "dipendente_id"),
    // FOREIGN KEY dell'altra classe
    inverseJoinColumns = @JoinColumn(name = "responsabile_id")

)
// SET evita i duplicati
private Set<Responsabile> responsabili = new HashSet<>();

  @ManyToMany
  @JoinTable(
        name = "dipendente_commessa",
        joinColumns = @JoinColumn(name = "dipendente_id"),
        inverseJoinColumns = @JoinColumn(name = "commessa_id")

    )
    @JsonIgnore
    private Set<Commessa> commesse = new HashSet<>();

  @OneToMany(mappedBy = "dipendente")
  @JsonIgnore
  private List<Timesheet> timesheets = new ArrayList<>();


  // getters and setters
  public Long getId() {
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome=nome;
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
  public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public List<Contratto> getContratti() {
  return contratti;
}
public void setContratti(List<Contratto> contratti) {
  this.contratti = contratti;
}
public Set<Responsabile> getResponsabili() {
  return responsabili;
}
public void setResponsabili(Set<Responsabile> responsabili) {
  this.responsabili = responsabili;
}
public Set<Commessa> getCommesse() {
  return commesse;
}
public void setCommesse(Set<Commessa> commesse) {
  this.commesse = commesse;
}
public List<Timesheet> getTimesheets() {
  return timesheets;
}
public void setTimesheets(List<Timesheet> timesheets) {
  this.timesheets = timesheets;
}


 
  
  
}