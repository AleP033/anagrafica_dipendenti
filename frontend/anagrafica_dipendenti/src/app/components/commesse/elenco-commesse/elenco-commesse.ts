import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Commessa } from '../../../models/Commessa/commessa';
import { CommessaService } from '../../../services/Commessa/commessa.service';

@Component({
  selector: 'app-elenco-commesse',
  imports: [CommonModule],
  templateUrl: './elenco-commesse.html',
  styleUrl: './elenco-commesse.css',
})
export class ElencoCommesse implements OnInit {

   commesse: Commessa[] = [];
  
    constructor(private comService: CommessaService) {}
  
    ngOnInit(): void {
      this.comService.getCommesse().subscribe({
        next: (data) => {
          this.commesse = data;
        },
        error: (err) => {
          console.error('Errore nel recupero delle commesse:', err);
        }
      });
    }
}
