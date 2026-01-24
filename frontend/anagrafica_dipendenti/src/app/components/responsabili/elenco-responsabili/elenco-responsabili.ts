import { Component, OnInit } from '@angular/core';
import { Responsabile } from '../../../models/Responsabile/responsabile';
import { ResponsabileService } from '../../../services/Responsabile/responsabile.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-elenco-responsabili',
  imports: [CommonModule],
  templateUrl: './elenco-responsabili.html',
  styleUrl: './elenco-responsabili.css',
})
export class ElencoResponsabili implements OnInit {

  responsabili: Responsabile[] = [];
  
    constructor(private respService: ResponsabileService) {}
  
    ngOnInit(): void {
      this.respService.getResponsabili().subscribe({
        next: (data) => {
          this.responsabili = data;
        },
        error: (err) => {
          console.error('Errore nel recupero dei responsabili:', err);
        }
      });
    }

}
