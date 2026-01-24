import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Dipendente } from "../../models/Dipendente/dipendente";
@Injectable({
  providedIn: 'root'
})
export class DipendenteService {

  private apiUrl = 'http://localhost:8080/dipendenti';

  constructor(private http: HttpClient) {}

  getDipendenti(): Observable<Dipendente[]> {
    return this.http.get<Dipendente[]>(this.apiUrl);
  }

  getDipendenteById(id: number): Observable<Dipendente> {
    return this.http.get<Dipendente>(`${this.apiUrl}/${id}`);
  }
}

// ho usato Dipendente e non DipendenteDTO perchè sono la stessa cosa e non ho voluto ricreare 
// altri ModelsDTO nel frontend