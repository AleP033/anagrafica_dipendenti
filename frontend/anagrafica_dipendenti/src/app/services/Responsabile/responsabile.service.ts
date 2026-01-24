import { Injectable } from '@angular/core';
import { Responsabile } from '../../models/Responsabile/responsabile';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ResponsabileService {

   private apiUrl = 'http://localhost:8080/responsabili';

  constructor(private http: HttpClient) {}

  getResponsabili(): Observable<Responsabile[]> {
    return this.http.get<Responsabile[]>(this.apiUrl);
  }

  getResponsabileById(id: number): Observable<Responsabile> {
    return this.http.get<Responsabile>(`${this.apiUrl}/${id}`);
  }
  
}
