import { Injectable } from '@angular/core';
import { Commessa } from '../../models/Commessa/commessa';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommessaService {

  private apiUrl = 'http://localhost:8080/commesse';

  constructor(private http: HttpClient) {}

  getCommesse(): Observable<Commessa[]> {
    return this.http.get<Commessa[]>(this.apiUrl);
  }

  getCommesseById(id: number): Observable<Commessa> {
    return this.http.get<Commessa>(`${this.apiUrl}/${id}`);
  }

  getCommesseByDipendente(id: number): Observable<Commessa[]> {
          return this.http.get<Commessa[]>(`${this.apiUrl}/dipendente/${id}`);
  }

  getCommesseByResponsabile(id: number): Observable<Commessa[]> {
    return this.http.get<Commessa[]>(`${this.apiUrl}/responsabile${id}`);
  }

  getCommesseByTimesheet(id: number): Observable<Commessa[]> {
    return this.http.get<Commessa[]>(`${this.apiUrl}/timesheet${id}`);
  }
  
}
