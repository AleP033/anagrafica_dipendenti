import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Timesheet } from '../../models/Timesheet/timesheet';

@Injectable({
  providedIn: 'root',
})
export class TimesheetService {

  private apiUrl = 'http://localhost:8080/timesheet';

  constructor(private http:HttpClient ) {}

  getTimesheet(): Observable<Timesheet[]> {
    return this.http.get<Timesheet[]>(this.apiUrl);
  }
  
  getTimesheetById(id: number): Observable<Timesheet> {
    return this.http.get<Timesheet>(`${this.apiUrl}/${id}`);
  }

  getTimesheetByDipendente(id: number): Observable<Timesheet[]> {
    return this.http.get<Timesheet[]>(`${this.apiUrl}/dipendente/${id}`);
  }

   getTimesheetByCommessa(id: number): Observable<Timesheet[]> {
    return this.http.get<Timesheet[]>(`${this.apiUrl}/commesse/${id}`);
  }
}
