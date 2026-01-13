package com.example.anagrafica_dipendenti.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



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
  private List<Contratto> contratti;

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

 
  
  
}