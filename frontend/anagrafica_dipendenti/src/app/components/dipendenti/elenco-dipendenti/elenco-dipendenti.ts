import { Component, OnInit } from '@angular/core';
import { DipendenteService } from '../../../services/Dipendente/dipendente.service';
import { Dipendente } from '../../../models/Dipendente/dipendente';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-elenco-dipendenti',
  imports: [CommonModule],
  templateUrl: './elenco-dipendenti.html',
  styleUrls: ['./elenco-dipendenti.css']
})
export class ElencoDipendenti implements OnInit {

  dipendenti: Dipendente[] = [];

  constructor(private dipService: DipendenteService) {}

  ngOnInit(): void {
    this.dipService.getDipendenti().subscribe({
      next: (data) => {
        this.dipendenti = data;
      },
      error: (err) => {
        console.error('Errore nel recupero dei dipendenti:', err);
      }
    });
  }
}
