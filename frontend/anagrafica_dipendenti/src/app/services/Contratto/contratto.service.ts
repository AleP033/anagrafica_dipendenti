import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contratto } from '../../models/Contratto/contratto';

@Injectable({
  providedIn: 'root',
})
export class ContrattoService {

  private apiUrl = 'http://localhost:8080/contratti';

    constructor(private http: HttpClient) {}

      getContratti(): Observable<Contratto[]> {
        return this.http.get<Contratto[]>(this.apiUrl);
      }
    
      getContrattoById(id: number): Observable<Contratto> {
        return this.http.get<Contratto>(`${this.apiUrl}/${id}`);
      }

      getContrattiByDipendente(id: number): Observable<Contratto[]> {
        return this.http.get<Contratto[]>(`${this.apiUrl}/dipendente/${id}`);
}


  
}
