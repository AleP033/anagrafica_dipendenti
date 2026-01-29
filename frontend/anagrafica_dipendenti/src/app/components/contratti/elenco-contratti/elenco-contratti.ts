import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Contratto } from '../../../models/Contratto/contratto';
import { ContrattoService } from '../../../services/Contratto/contratto.service';

@Component({
  selector: 'app-elenco-contratti',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './elenco-contratti.html',
  styleUrl: './elenco-contratti.css',
})
export class ElencoContratti implements OnInit {

  contratti: Contratto[] = [];
  
    constructor(private conService: ContrattoService) {}
  
    ngOnInit(): void {
    this.conService.getContratti().subscribe({
      next: (data) => {
        this.contratti = data;
      },
      error: (err) => {
        console.error("Errore nel recupero dei contratti", err);
      }
    });
  }
    }

